package com.ccb.ProdPms.util;

/**
 * @ClassName: RespCode
 * @Description: 维护状态码
 * @author lhy-pc
 * @date 2018年11月8日
 * 
 */
public enum RespCode {

	SUCCESS(0, "请求成功"), WARN(-1, "网络异常，请稍后重试");

	private int code;
	private String msg;

	RespCode(int code, String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}
