package com.piece.entity;

import java.io.Serializable;	
@SuppressWarnings("serial")
public class UserId  implements Serializable{
	private int id;
	private String account;
	
	
	public UserId(int id, String account) {

		this.id = id;
		this.account = account;
	}
	public UserId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	

}
