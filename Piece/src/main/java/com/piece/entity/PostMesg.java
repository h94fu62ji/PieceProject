package com.piece.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post_mesg")
public class PostMesg {

	@Id
	@Column(name = "mesg_id")
	private int messageId;

	@Column(name = "post_id")
	private int postId;

	@Column(name = "sender_id")
	private int senderId;

	@Column(name = "text")
	private String text;

	@Column(name = "time")
	private LocalDateTime time;

	@Column(name = "up")
	private int up;

	public PostMesg() {
		super();
	}

	public PostMesg(int messageId, int postId, int senderId, String text, LocalDateTime time, int up) {
		super();
		this.messageId = messageId;
		this.postId = postId;
		this.senderId = senderId;
		this.text = text;
		this.time = time;
		this.up = up;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
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

}
