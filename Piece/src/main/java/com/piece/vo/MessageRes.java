package com.piece.vo;

import java.util.List;

import com.piece.entity.Message;

public class MessageRes {
	
	private String code;
	
	private String msg;
	
	private List<Message> mList;

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

	public List<Message> getmList() {
		return mList;
	}

	public void setmList(List<Message> mList) {
		this.mList = mList;
	}

	public MessageRes(String code, String msg, List<Message> mList) {
		super();
		this.code = code;
		this.msg = msg;
		this.mList = mList;
	}
	
	
}
