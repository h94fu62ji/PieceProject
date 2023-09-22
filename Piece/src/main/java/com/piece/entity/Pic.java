package com.piece.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pic")
public class Pic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pic_id")
	private int picId;
	@Column(name = "pic_address")
	private String picAdd;

	public Pic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pic(String picAdd) {
		super();
		this.picAdd = picAdd;
	}

	public Pic(int picId, String picAdd) {
		super();
		this.picId = picId;
		this.picAdd = picAdd;
	}

	public int getPicId() {
		return picId;
	}

	public void setPicId(int picId) {
		this.picId = picId;
	}

	public String getPicAdd() {
		return picAdd;
	}

	public void setPicAdd(String picAdd) {
		this.picAdd = picAdd;
	}

}
