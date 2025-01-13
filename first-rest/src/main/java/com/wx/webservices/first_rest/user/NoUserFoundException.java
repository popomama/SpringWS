package com.wx.webservices.first_rest.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class NoUserFoundException extends RuntimeException {

	public NoUserFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoUserFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NoUserFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoUserFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoUserFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
	
}
