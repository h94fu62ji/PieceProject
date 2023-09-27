package com.piece.vo;

import java.time.LocalDateTime;

public class GetPostByIdVo {
	private String senderId;
	private int postImg;
	private int userImg;
	private String text;
	private int up;
	private LocalDateTime time;

	public GetPostByIdVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetPostByIdVo(String senderId, int postImg, int userImg, String text, int up, LocalDateTime time) {
		super();
		this.senderId = senderId;
		this.postImg = postImg;
		this.userImg = userImg;
		this.text = text;
		this.up = up;
		this.time = time;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public int getPostImg() {
		return postImg;
	}

	public void setPostImg(int postImg) {
		this.postImg = postImg;
	}

	public int getUserImg() {
		return userImg;
	}

	public void setUserImg(int userImg) {
		this.userImg = userImg;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

}
