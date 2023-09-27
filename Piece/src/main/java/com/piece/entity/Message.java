package com.piece.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chat_mesg")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mesg_id")
	private int messageId;

	@Column(name = "chat_id")
	private int chatroomId;

	@Column(name = "sender_id")
	private String sender;

//	@Column(name = "reciever")
//	private String reciever;

	@Column(name = "text")
	private String messageContent;

	@Column(name = "time")
	private LocalDateTime datetime = LocalDateTime.now();

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getChatroomId() {
		return chatroomId;
	}

	public void setChatroomId(int chatroomId) {
		this.chatroomId = chatroomId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

//	public String getReciever() {
//		return reciever;
//	}
//
//	public void setReciever(String reciever) {
//		this.reciever = reciever;
//	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(int chatroomId, String sender, String messageContent) {
		super();
		this.chatroomId = chatroomId;
		this.sender = sender;
		this.messageContent = messageContent;
		this.datetime = LocalDateTime.now();
	}

}