package com.ccb.ProdPms.entity;

import com.ccb.ProdPms.util.RespCode;

import lombok.Data;

/**
 * @ClassName: RestRespEntity
 * @Description: 封装响应报文model。接口响应至少需要三项信息：状态码、描述、数据。其中，数据不是每个接口必须的。
 * @author lhy-pc
 * @date 2018年11月8日
 * 
 */
@Data
public class RestRespEntity {

	private int code;
	private String msg;
	private Object data;

	public RestRespEntity(RespCode respCode) {
	        this.code = respCode.getCode();
	        this.msg = respCode.getMsg();
	    }

	public RestRespEntity(RespCode respCode, Object data) {
	        this(respCode);
	        this.data = data;
	    }
}
