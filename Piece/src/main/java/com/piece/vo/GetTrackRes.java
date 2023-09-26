package com.piece.vo;

public class GetTrackRes {
	private String code;
	private String mesg;
	private int track;
	private int fans;

	public GetTrackRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public GetTrackRes(String code, String mesg) {
		super();
		this.code = code;
		this.mesg = mesg;

	}
	
	public GetTrackRes(String code, String mesg, int track, int fans) {
		super();
		this.code = code;
		this.mesg = mesg;
		this.track = track;
		this.fans = fans;
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

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	public int getFans() {
		return fans;
	}

	public void setFans(int fans) {
		this.fans = fans;
	}

}
