package com.piece.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private int postId;
	@Column(name = "sender_id")
	private String senderId;
	@Column(name = "share_id")
	private String shareId;
	@Column(name = "text")
	private String text;
	@Column(name = "time")
	private LocalDateTime time;
	@Column(name = "up")
	private int up;
	@Column(name = "pic_id")
	private int picId;
	@Column(name = "public")
	private boolean pub;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 新增貼文用
	public Post(String senderId, String text, int picId, boolean pub) {
		super();
		this.senderId = senderId;
		this.text = text;
		this.picId = picId;
		this.pub = pub;
	}

	public Post(int postId, String senderId, String shareId, String text, LocalDateTime time, int up, int picId,
			boolean pub) {
		super();
		this.postId = postId;
		this.senderId = senderId;
		this.shareId = shareId;
		this.text = text;
		this.time = time;
		this.up = up;
		this.picId = picId;
		this.pub = pub;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getPicId() {
		return picId;
	}

	public void setPicId(int picId) {
		this.picId = picId;
	}

	public boolean isPub() {
		return pub;
	}

	public void setPub(boolean pub) {
		this.pub = pub;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", senderId=" + senderId + ", shareId=" + shareId + ", text=" + text
				+ ", time=" + time + ", up=" + up + ", picId=" + picId + ", access=" + pub + "]";
	}
}
