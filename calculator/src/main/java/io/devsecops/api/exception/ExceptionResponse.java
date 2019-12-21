package io.devsecops.api.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Date timestamp;
	private String messages;
	private String details;
	
	public ExceptionResponse(Date timestamp, String messages, String details) {
		super();
		this.timestamp = timestamp;
		this.messages = messages;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessages() {
		return messages;
	}

	public String getDetails() {
		return details;
	}
	
}
