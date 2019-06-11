package org.sajal.rest.messenger.exception;

public class InvalidRequestException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1462795468240407636L;

	public InvalidRequestException(String excMessage) {
		super(excMessage);
	}
	
}
