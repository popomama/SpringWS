package com.wx.webservices.first_rest.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDetails {

	LocalDateTime timestamp;
	
	String messsage;
	String details;
	@Override
	public String toString() {
		return "ErrorDetails [timestamp=" + timestamp + ", messsage=" + messsage + ", details=" + details + "]";
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public String getMesssage() {
		return messsage;
	}
	public String getDetails() {
		return details;
	}
	public ErrorDetails(LocalDateTime timestamp, String messsage, String details) {
		super();
		this.timestamp = timestamp;
		this.messsage = messsage;
		this.details = details;
	}
	
}
