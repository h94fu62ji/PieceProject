package com.piece.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piece.constants.RtnCode;
import com.piece.entity.Chatroom;
import com.piece.entity.Message;
import com.piece.repository.ChatroomDao;
import com.piece.repository.MessageDao;
import com.piece.vo.ChatroomRes;
import com.piece.vo.MessageRes;
import com.piece.vo.SetReadMsgIdReq;
import com.piece.vo.SetReadMsgIdRes;

@CrossOrigin
@RestController
public class RestfulController {

	@Autowired
	private ChatroomDao chatroomDao;

	@Autowired
	private MessageDao messageDao;

	@GetMapping("/chatAll")
	public ChatroomRes getAllChatroom(@RequestParam int currentUserId) {
		List<Chatroom> res = chatroomDao.findByUser1OrUser2(currentUserId);

		if (res.size() == 0) {
			return new ChatroomRes(RtnCode.DATA_NOT_FOUND.getCode(), RtnCode.DATA_NOT_FOUND.getMessage(), null);
		}

		return new ChatroomRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);

	}

	@GetMapping("/allMsg/{chatroomId}")
	public MessageRes getAllMsgInChatroom(@PathVariable int chatroomId) {
		List<Message> res = messageDao.getAllMsgInChatroom(chatroomId);

//		Collections.sort(res);

		return new MessageRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), res);
	}

	@GetMapping("/findByChatroomId")
	public Chatroom findByChatroomId(@RequestParam int chatroomId) {
		return chatroomDao.findByChatroomId(chatroomId);
	}

	@PostMapping("/setReadMsgId")
	public SetReadMsgIdRes setReadMsgId(@RequestBody SetReadMsgIdReq setReadMsgIdReq) {
		Chatroom chatroom = chatroomDao.findByChatroomId(setReadMsgIdReq.getChatroomId());

		System.out.println(setReadMsgIdReq.getUser());
		if (chatroom.getUser1() == setReadMsgIdReq.getUser()) {
			// 如果當前使用者是這個聊天室的user1的話
			chatroom.setUser1Read(setReadMsgIdReq.getLastReadMsgId());
		}
		if (chatroom.getUser2() == setReadMsgIdReq.getUser()) {
			// 若當前使用者是user2
			chatroom.setUser2Read(setReadMsgIdReq.getLastReadMsgId());
		}
		chatroomDao.save(chatroom);
		return new SetReadMsgIdRes(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(),
				setReadMsgIdReq.getLastReadMsgId());

	}
}
