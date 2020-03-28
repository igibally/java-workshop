package com.test.javaworkshop.exception;

/**
 * 
 * @author ielgebally
 *
 */
public class DataBaseNotAvailableException extends RuntimeException {
	
	private static final long serialVersionUID = -1106949636370576651L;
	private String exceptionMessage;
	
	public DataBaseNotAvailableException() {
		super();
	}
	public DataBaseNotAvailableException(String exceptionMessage) {
		super(exceptionMessage);
	}
	
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
