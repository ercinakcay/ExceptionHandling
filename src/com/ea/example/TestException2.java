package com.ea.example;

import com.ea.exception.BusinessException;
import com.ea.exception.EnumErrorCode;

public class TestException2 {

	public static void main( String[] args ) {

		try {
			throw new BusinessException( EnumErrorCode.NULL_BUSSINES_VALUE );
		} catch( BusinessException e ) {
			if( e.getErrorCode() == EnumErrorCode.NULL_BUSSINES_VALUE ) {
//				e.printStackTrace();
				/* Do whatever you want
				 * .
				 * .
				 * */
				System.out.println( "Catch ends." );
			}
		}

	}
}
