package com.piece.vo;

public class GetPostReq {
	private int postId;

	public GetPostReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetPostReq(int postId) {
		super();
		this.postId = postId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

}
