package com.piece.vo;

import com.piece.entity.User;

public class UserRes {

	private User user;
	private String code;
	private String message;
	private String account;
	private String pwd;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public UserRes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRes(User user, String code, String message) {

		this.user = user;
		this.code = code;
		this.message = message;
	}
	public UserRes(String account, String pwd) {

		this.account = account;
		this.pwd = pwd;
	}
	public UserRes(String code, String message, String account, String pwd) {
		super();
		this.code = code;
		this.message = message;
		this.account = account;
		this.pwd = pwd;
	}
	
	
	
	
	

}
