package com.bing.resume.framework.web.handler;

import java.io.Serializable;

/**
 * @author chenbing 
 * Specification : 文档说明 json响应前端数据的封装对象
 */
public class ResponseData implements Serializable {

	private static final long serialVersionUID = -5635854670090328312L;

	private String rspCode;

	private String rspMsg;
	
	/**
	 * 0表示处理成功 1表示处理失败
	 */
	private Integer status;
	
	private Long timestamp;
	
	private Object object;
	
	public Object getObject() {
		return object;
	}

	public ResponseData setObject(Object object) {
		this.object = object;
		return this;
	}

	public ResponseData(Integer status) {
		this.status = status;
	}
	
	public ResponseData(String rspCode, String rspMsg, Integer status) {
		this.rspCode = rspCode;
		this.rspMsg = rspMsg;
		this.status = status;
	}
	
	public ResponseData(String rspCode, String rspMsg, Integer status,
			Long timestamp) {
		this.rspCode = rspCode;
		this.rspMsg = rspMsg;
		this.status = status;
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public ResponseData() {
	}

	public ResponseData(String rspCode, String rspMsg) {
		super();
		this.rspCode = rspCode;
		this.rspMsg = rspMsg;
	}

	public String getRspCode() {
		return rspCode;
	}


	public String getRspMsg() {
		return rspMsg;
	}

	public void setRspCode(String rspCode) {
		this.rspCode = rspCode;
	}

	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}
	
}
