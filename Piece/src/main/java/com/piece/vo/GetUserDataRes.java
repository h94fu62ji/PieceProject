package com.piece.vo;

import com.piece.entity.UserData;

public class GetUserDataRes {
	private String code;
	private String mesg;
	private UserData userData;

	public GetUserDataRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetUserDataRes(String code, String mesg, UserData userData) {
		super();
		this.code = code;
		this.mesg = mesg;
		this.userData = userData;
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

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}

}
