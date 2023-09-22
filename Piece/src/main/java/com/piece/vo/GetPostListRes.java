package com.piece.vo;

import java.util.List;

public class GetPostListRes {
	private String code;
	private String mesg;
	private List<String> postList;

	public GetPostListRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetPostListRes(String code, String mesg, List<String> postList) {
		super();
		this.code = code;
		this.mesg = mesg;
		this.postList = postList;
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

	public List<String> getPostList() {
		return postList;
	}

	public void setPostList(List<String> postList) {
		this.postList = postList;
	}

}
