package com.piece.vo;

public class NewPostRes {
	private String code;
	private String mesg;
	private int postId;

	public NewPostRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NewPostRes(String code, String mesg, int postId) {
		super();
		this.code = code;
		this.mesg = mesg;
		this.postId = postId;
	}

	public NewPostRes(String code, String mesg) {
		super();
		this.code = code;
		this.mesg = mesg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

}
