package com.piece.vo;

public class SetReadMsgIdReq {

	private int chatroomId; 
	
	private int user;
	
	private int lastReadMsgId;

	public int getChatroomId() {
		return chatroomId;
	}

	public void setChatroomId(int chatroomId) {
		this.chatroomId = chatroomId;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getLastReadMsgId() {
		return lastReadMsgId;
	}

	public void setLastReadMsgId(int lastReadMsgId) {
		this.lastReadMsgId = lastReadMsgId;
	}

	public SetReadMsgIdReq(int chatroomId, int user, int lastReadMsgId) {
		super();
		this.chatroomId = chatroomId;
		this.user = user;
		this.lastReadMsgId = lastReadMsgId;
	}

	public SetReadMsgIdReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
