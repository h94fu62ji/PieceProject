package com.piece.constants;

public enum RtnCode {

	SUCCESSFUL("200", "successful!"), //
	DATA_ERROR("400", "data error"), //
	DATA_EXISTED("400", "data existed"), //
	DATA_NOT_FOUND("400", "data not found"), //
	ACCOUNT_EXISTED("400", "account existed"), //
	ACCOUNT_NOT_FOUND("404", "account not found"), //
	PLEASE_LOGIN_FIRST("400", "please login first");

	private String code;

	private String message;

	private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
