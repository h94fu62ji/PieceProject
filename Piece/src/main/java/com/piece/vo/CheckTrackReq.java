package com.piece.vo;

public class CheckTrackReq {
	private String user;
	private String userId;

	public CheckTrackReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckTrackReq(String user, String userId) {
		super();
		this.user = user;
		this.userId = userId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
