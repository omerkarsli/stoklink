package com.stoklink.API.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resp {

	private String status;
	private List<Urun> data;
	private String message;

	public Resp() {

	}

	public Resp(String status, List<Urun> data) {
		this.status = status;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Urun> getData() {
		return data;
	}

	public void setData(List<Urun> data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "status=" + status + ", data=" + data + ", message=" + message;
	}

}
