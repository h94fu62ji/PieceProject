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

	@MessageMapping("/chat/{chatroomId}")//�nsend��u/app/chat/{�ʺAid}�v
	@SendTo("/topic/chat/{chatroomId}")//�n�q�\�u/topic/chat/{�ʺAid}�v
	public Message sendMessage(@DestinationVariable("chatroomId") int chatroomId, Message message) {
		System.out.println("����T���G");
		System.out.println(message.getChatroomId());
		System.out.println(message.getSender());
//		System.out.println(message.getReciever());
		System.out.println("���e�G" + message.getMessageContent());
		
		Message m =  messageDao.save(message);//�n��o�x�s�᪺��ơA�_�h�e�ݮ�����messageId
		
		return m;
		
	}
}
