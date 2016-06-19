package com.ea.example;

import com.ea.exception.EnumErrorCode;

public class TestException3 {

	public static void main( String[] args ) {

		System.out.println( EnumErrorCode.getExceptionMessage( EnumErrorCode.TOO_SHORT_FOR_BUSSINESS_FIELD ) );
	}
}
