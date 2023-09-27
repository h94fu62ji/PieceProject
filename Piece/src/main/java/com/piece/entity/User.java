package com.piece.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class User {

	@Id
	@Column(name = "account")
	private String account;

	@Column(name = "pwd")
	private String pwd;

	@Column(name = "create_date")
	private LocalDate createDate;

	@Column(name = "account_state")
	private Boolean accountState;

	@Column(name = "admin_state")
	private Boolean adminState;
	
	
	

	public User(String account, String pwd) {
		super();
		this.account = account;
		this.pwd = pwd;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String account, String pwd, LocalDate createDate, Boolean accountState, Boolean adminState) {
		super();
		this.account = account;
		this.pwd = pwd;
		this.createDate = createDate;
		this.accountState = accountState;
		this.adminState = adminState;
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

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Boolean getAccountState() {
		return accountState;
	}

	public void setAccountState(Boolean accountState) {
		this.accountState = accountState;
	}

	public Boolean getAdminState() {
		return adminState;
	}

	public void setAdminState(Boolean adminState) {
		this.adminState = adminState;
	}
	
	
	
	

}
