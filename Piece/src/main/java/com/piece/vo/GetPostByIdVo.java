package com.piece.vo;

import java.time.LocalDateTime;

public class GetPostByIdVo {
	private int userId;
	private int postImg;
	private int userImg;
	private String text;
	private int up;
	private LocalDateTime time;

	public GetPostByIdVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetPostByIdVo(int userId, int postImg, int userImg, String text, int up, LocalDateTime time) {
		super();
		this.userId = userId;
		this.postImg = postImg;
		this.userImg = userImg;
		this.text = text;
		this.up = up;
		this.time = time;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
