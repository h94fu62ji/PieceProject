package com.piece.vo;

public class GetPostListReq {
	private int userId;

	public GetPostListReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetPostListReq(int userId) {
		super();
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
