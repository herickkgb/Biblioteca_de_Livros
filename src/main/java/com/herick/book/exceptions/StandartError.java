package com.herick.book.exceptions;

public class StandartError {
	private Long timestamp;
	private Integer status;
	private String error;

	public StandartError(Long timestamp, Integer status, String error) {
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	public StandartError() {
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
