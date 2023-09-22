package com.piece.vo;

import java.util.List;

import com.piece.entity.Chatroom;

public class ChatroomRes {
	
	private String code;
	
	private String msg;
	
	private List<Chatroom> cList;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Chatroom> getcList() {
		return cList;
	}

	public void setcList(List<Chatroom> cList) {
		this.cList = cList;
	}

	public ChatroomRes(String code, String msg, List<Chatroom> cList) {
		super();
		this.code = code;
		this.msg = msg;
		this.cList = cList;
	}
	
	
}
