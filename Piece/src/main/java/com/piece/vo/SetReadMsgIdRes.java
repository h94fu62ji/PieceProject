package com.piece.vo;

public class SetReadMsgIdRes {
	
	private String code;
	
	private String msg;
	
	private int lastReadMsgId;

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

	public int getLastReadMsgId() {
		return lastReadMsgId;
	}

	public void setLastReadMsgId(int lastReadMsgId) {
		this.lastReadMsgId = lastReadMsgId;
	}

	public SetReadMsgIdRes(String code, String msg, int lastReadMsgId) {
		super();
		this.code = code;
		this.msg = msg;
		this.lastReadMsgId = lastReadMsgId;
	}


	
	
}
