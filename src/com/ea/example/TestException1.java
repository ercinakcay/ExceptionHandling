package com.ea.example;

import com.ea.exception.BusinessException;
import com.ea.exception.EnumErrorCode;

public class TestException1 {

	public static void main( String[] args ) {
		validate( "input", "2016qwe" );
	}

	private static boolean validate( String i_field, String i_value ) {

		boolean isValid = false;
		if( i_value == null || i_value.length() == 0 || !i_value.contains( "w" ) ) {
			throw new BusinessException( EnumErrorCode.INVALID_BUSSINES_VALUE )
				.set( "field", i_field )
				.set( "value", i_value )
				.set( "charSequence", "[w]" );
		}
		return isValid;
	}

}
