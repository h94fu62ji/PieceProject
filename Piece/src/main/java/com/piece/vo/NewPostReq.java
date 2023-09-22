package com.piece.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewPostReq {
	@JsonProperty("id")
	private int sender_id;
	private String text;
	@JsonProperty("img")
	private String pic64;
	private boolean pub;

	public NewPostReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewPostReq(int sender_id, String text, String pic64, boolean pub) {
		super();
		this.sender_id = sender_id;
		this.text = text;
		this.pic64 = pic64;
		this.pub = pub;
	}

	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
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
