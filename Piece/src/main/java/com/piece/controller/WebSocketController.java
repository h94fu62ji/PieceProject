package com.piece.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.piece.entity.Message;
import com.piece.repository.MessageDao;

@CrossOrigin
@Controller
public class WebSocketController {
	
	@Autowired
	private MessageDao messageDao;

	@MessageMapping("/chat/{chatroomId}")//要send到「/app/chat/{動態id}」
	@SendTo("/topic/chat/{chatroomId}")//要訂閱「/topic/chat/{動態id}」
	public Message sendMessage(@DestinationVariable("chatroomId") int chatroomId, Message message) {
		System.out.println("收到訊息：");
		System.out.println(message.getChatroomId());
		System.out.println(message.getSender());
//		System.out.println(message.getReciever());
		System.out.println("內容：" + message.getMessageContent());
		
		Message m =  messageDao.save(message);//要獲得儲存後的資料，否則前端拿不到messageId
		
		return m;
		
	}
}
