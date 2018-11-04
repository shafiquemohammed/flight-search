package com.amadeus.asr.exceptions;

public class AmadeusFlightSearchExceptionHandler extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int errorCode;

	public AmadeusFlightSearchExceptionHandler() {
		super();
	}
	
	public AmadeusFlightSearchExceptionHandler(String message) {
		super(message);
	}

	public AmadeusFlightSearchExceptionHandler(String message, int code) {
		super(message);
		this.errorCode = code;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public String getMessage() {
		return super.getMessage() ;
	}


}
