package com.piece.vo;

public class GetPostRes {
	private String code;
	private String mesg;
	private GetPostByIdVo gpbiv;

	public GetPostRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetPostRes(String code, String mesg, GetPostByIdVo gpbiv) {
		super();
		this.code = code;
		this.mesg = mesg;
		this.gpbiv = gpbiv;
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

	public GetPostByIdVo getGpbiv() {
		return gpbiv;
	}

	public void setGpbiv(GetPostByIdVo gpbiv) {
		this.gpbiv = gpbiv;
	}

}
