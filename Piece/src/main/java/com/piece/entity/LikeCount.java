package com.piece.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "like_count")
public class LikeCount {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "post_mesg_id")
	private int postMesgId;

	@Column(name = "user_id")
	private int userId;

	public LikeCount() {
		super();

	}

	public LikeCount(int id, int postMesgId, int userId) {
		super();
		this.id = id;
		this.postMesgId = postMesgId;
		this.userId = userId;
	}

	public LikeCount(int postMesgId, int userId) {
		super();
		this.postMesgId = postMesgId;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPostMesgId() {
		return postMesgId;
	}

	public void setPostMesgId(int postMesgId) {
		this.postMesgId = postMesgId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
