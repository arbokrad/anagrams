package com.starkc.angrams;

public class Harness {

	public static void main(String[] args) {
				
		AngramChecker ac = new AngramChecker();

		doCheck( ac, "testme", "testme" );
		doCheck( ac, "TESTME", "test me" );
		doCheck( ac, "testme", "testing me" );
		doCheck( ac, ".test.me.", "testme" );
		doCheck( ac, "", "testme" );
		doCheck( ac, null, "testme" );
		
	}
	
	private static void doCheck( AngramChecker ac, String str1, String str2 ) {
		System.out.println( str1 + "  vs.  " + str2 );
		System.out.println( ac.isAngram(str1, str2) );	
	}
}
