package com.ea.exception;

import java.util.ResourceBundle;

/**
 * Error code information and validation enumeration. 
 * <p>
 * Error message value store as enum variable {@code errorMessage} and property files. 
 * <p>
 * With this structure both can be used.
 * @author ercinakcay
 */
public enum EnumErrorCode {

	NULL_BUSSINES_VALUE( "NULL_BUSSINES_VALUE", 1001, "Bussiness value has entered as empty value." ), 
	INVALID_BUSSINES_VALUE( "INVALID_BUSSINES_VALUE", 1002, "Entered bussines value is not valid." ), 
	TOO_SHORT_FOR_BUSSINESS_FIELD( "TOO_SHORT_FOR_BUSSINESS_FIELD", 1003, "Entered field is too short as a bussiness value." );

	private String errorName;
	private int errorCode;
	private String errorMessage;
	
	EnumErrorCode( String i_errorName, int i_errorCode, String i_errorMessage ) {
		this.errorName = i_errorName;
		this.errorCode = i_errorCode;
		this.errorMessage = i_errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode( int errorCode ) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage( String errorMessage ) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorName() {
		return errorName;
	}

	public void setErrorName( String errorName ) {
		this.errorName = errorName;
	}

	/**
	 * Gets exception message from propery file at {@link exceptions.properties}
	 * @return
	 */
	public static String getExceptionMessage( EnumErrorCode i_errorCode ) {
		ResourceBundle bundle = ResourceBundle.getBundle( "com.ea.example.exceptions" );
		return bundle.getString( i_errorCode.getErrorName() );
	}
	
}
