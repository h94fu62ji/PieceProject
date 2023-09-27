package com.piece.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserIdReq {
	@JsonProperty("id")
	private String userId;

	public UserIdReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserIdReq(String userId) {
		super();
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
