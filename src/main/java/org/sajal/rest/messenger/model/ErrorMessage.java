package org.sajal.rest.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String errorCode;
	private String errorMessage;
	private String helpText;
	
	
	public ErrorMessage() {
		
	}


	public ErrorMessage(String errorCode, String errorMessage, String helpText) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.helpText = helpText;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public String getHelpText() {
		return helpText;
	}


	public void setHelpText(String helpText) {
		this.helpText = helpText;
	}
	
	
	
}
