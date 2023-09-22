package com.piece.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chat")
public class Chatroom {

	@Id
	@Column(name = "chat_id")
	private int chatroomId;

	@Column(name = "user_1")
	private int user1;

	@Column(name = "user_2")
	private int user2;

	@Column(name = "user_1_read")
	private int user1Read;

	@Column(name = "user_2_read")
	private int user2Read;

	public int getChatroomId() {
		return chatroomId;
	}

	public void setChatroomId(int chatroomId) {
		this.chatroomId = chatroomId;
	}

	public int getUser1() {
		return user1;
	}

	public void setUser1(int user1) {
		this.user1 = user1;
	}

	public int getUser2() {
		return user2;
	}

	public void setUser2(int user2) {
		this.user2 = user2;
	}

	public int getUser1Read() {
		return user1Read;
	}

	public void setUser1Read(int user1Read) {
		this.user1Read = user1Read;
	}

	public int getUser2Read() {
		return user2Read;
	}

	public void setUser2Read(int user2Read) {
		this.user2Read = user2Read;
	}

	public Chatroom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chatroom(int chatroomId, int user1, int user2, int user1Read, int user2Read) {
		super();
		this.chatroomId = chatroomId;
		this.user1 = user1;
		this.user2 = user2;
		this.user1Read = user1Read;
		this.user2Read = user2Read;
	}

}
