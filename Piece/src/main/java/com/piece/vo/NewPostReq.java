package com.piece.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewPostReq {
	@JsonProperty("id")
	private String senderId;
	private String text;
	@JsonProperty("img")
	private String pic64;
	private boolean pub;

	public NewPostReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewPostReq(String senderId, String text, String pic64, boolean pub) {
		super();
		this.senderId = senderId;
		this.text = text;
		this.pic64 = pic64;
		this.pub = pub;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPic64() {
		return pic64;
	}

	public void setPic64(String pic64) {
		this.pic64 = pic64;
	}

	public boolean isPub() {
		return pub;
	}

	public void setPub(boolean pub) {
		this.pub = pub;
	}

}
