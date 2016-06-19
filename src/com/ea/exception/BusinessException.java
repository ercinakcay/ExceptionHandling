package com.ea.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * Generic bussines exception for evaluation of message at status.
 * @author ercinakcay
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 6849822435769060596L;

	private EnumErrorCode errorCode;

	private final Map<String, Object> properties = new TreeMap<String, Object>();

	/**
	 * Default constructor.
	 */
	public BusinessException() {
	}

	/**
	 * Specialized constructor with {@link EnumErrorCode}.
	 * @param errorCode
	 */
	public BusinessException( EnumErrorCode errorCode ) {
		this.errorCode = errorCode;
	}

	public BusinessException( String message ) {
		super( message );
	}

	public BusinessException( String message, EnumErrorCode errorCode ) {
		super( message );
		this.errorCode = errorCode;
	}

	public BusinessException( Throwable cause, EnumErrorCode errorCode ) {
		super( cause );
		this.errorCode = errorCode;
	}

	public BusinessException( String message, Throwable cause, EnumErrorCode errorCode ) {
		super( message, cause );
		this.errorCode = errorCode;
	}

	public EnumErrorCode getErrorCode() {
		return errorCode;
	}

	public BusinessException setErrorCode( EnumErrorCode errorCode ) {
		this.errorCode = errorCode;
		return this;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}

	/**
	 * Adding properties to returning exception.
	 * @param name
	 * @return
	 */
	@SuppressWarnings( "unchecked" )
	public <T> T get( String name ) {
		return ( T ) properties.get( name );
	}

	/**
	 * Sets business exception specific situation fields.
	 * @param name
	 * @param value
	 * @return
	 */
	public BusinessException set( String name, Object value ) {
		properties.put( name, value );
		return this;
	}

	public void printStackTrace( PrintStream s ) {
		synchronized( s ) {
			printStackTrace( new PrintWriter( s ) );
		}
	}

	public void printStackTrace( PrintWriter s ) {
		synchronized( s ) {
			s.println( this );
			s.println( "\t-------------------------------" );
			if( errorCode != null ) {
				s.println( "\t" + errorCode + ":" + errorCode.getClass().getName() );
			}
			for( String key : properties.keySet() ) {
				s.println( "\t" + key + "=[" + properties.get( key ) + "]" );
			}
			s.println( "\t-------------------------------" );
			StackTraceElement[] trace = getStackTrace();
			for( int i = 0; i < trace.length; i++ )
				s.println( "\tat " + trace[i] );

			Throwable ourCause = getCause();
			if( ourCause != null ) {
				ourCause.printStackTrace( s );
			}
			s.flush();
		}
	}

}
