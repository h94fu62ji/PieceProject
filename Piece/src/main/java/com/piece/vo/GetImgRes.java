package com.piece.vo;

public class GetImgRes {
	private String code;
	private String mesg;
	private String img64;

	public GetImgRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetImgRes(String code, String mesg, String img64) {
		super();
		this.code = code;
		this.mesg = mesg;
		this.img64 = img64;
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

	public String getImg64() {
		return img64;
	}

	public void setImg64(String img64) {
		this.img64 = img64;
	}

}
