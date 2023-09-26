package com.piece.vo;

public class GetTrackRes {
	private String code;
	private String mesg;
	private int trackMe;
	private int track;

	public GetTrackRes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetTrackRes(String code, String mesg, int trackMe, int track) {
		super();
		this.code = code;
		this.mesg = mesg;
		this.trackMe = trackMe;
		this.track = track;
	}

	public GetTrackRes(String code, String mesg) {
		super();
		this.code = code;
		this.mesg = mesg;

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

	public int getTrackMe() {
		return trackMe;
	}

	public void setTrackMe(int trackMe) {
		this.trackMe = trackMe;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

}
