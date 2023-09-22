package com.piece.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_data")
public class UserData {
	@Id
	@Column(name = "user_id")
	private int userId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "birthday")
	private LocalDate birthday;
	@Column(name = "address")
	private String address;
	@Column(name = "introduce")
	private String introduce;
	@Column(name = "pic_id")
	private int picId;
	@Column(name = "sex")
	private String sex;

	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserData(int userId, String userName, LocalDate birthday, String address, String introduce, int picId,
			String sex) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.birthday = birthday;
		this.address = address;
		this.introduce = introduce;
		this.picId = picId;
		this.sex = sex;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public int getPicId() {
		return picId;
	}

	public void setPicId(int picId) {
		this.picId = picId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
