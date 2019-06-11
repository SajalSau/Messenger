package org.sajal.rest.messenger.exception;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1462795468240407636L;

	public DataNotFoundException(String excMessage) {
		super(excMessage);
	}
	
}
