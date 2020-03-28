package com.test.javaworkshop.exception;

/**
 * 
 * @author ielgebally
 *
 */
public class CountryNotFoundException extends Exception {
	
	private static final long serialVersionUID = -1106949636370576651L;
	private String exceptionMessage;
	
	public CountryNotFoundException() {
		super();
	}
	public CountryNotFoundException(String exceptionMessage) {
		super(exceptionMessage);
	}
	
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
