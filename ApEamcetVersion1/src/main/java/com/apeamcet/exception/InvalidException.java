package com.apeamcet.exception;

@SuppressWarnings("serial")
public class InvalidException extends Exception {
	
	String exception= null;
	public InvalidException(String exception) {
		super();
		this.exception = exception;
	}
	@Override
    public String getMessage() {
        return exception;
    }

}
