package com.starkc.angrams;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AngramChecker {
	
	public boolean isAngram( String str1, String str2 ) {
		
		// sanity check
		if( str1 == null || str2 == null ) {
			return false;
		}
		
		str1 = format( str1 );
		str2 = format( str2 );
		
		// sanity check
		if( str1.length() != str2.length() ) {
			return false;
		}
		
		Map<Character, Integer> str1Counts = getCharCounts( str1 );
		//printCharCounts( str1Counts );
		
		Map<Character, Integer> str2Counts = getCharCounts( str2 );
		//printCharCounts( str2Counts );
		
		return compareCounts( str1Counts, str2Counts);
	}
	
	private String format( String str ) {
		
		// strip a bunch of punctuation
		str = str.replaceAll( "[^a-zA-Z]+", "");
		return str.toLowerCase();
	}
	
	private Map<Character, Integer> getCharCounts( String str ) {
		
		Map<Character, Integer> charCounts = new HashMap<Character, Integer>();
		
		char[] chars = str.toCharArray();
		for( int i = 0; i < chars.length; i++ ) {
			
			if( charCounts.containsKey( chars[i] ) ) {
				Integer curCount = charCounts.get(chars[i]);
				charCounts.put( chars[i], curCount + 1 );
			} else {
				charCounts.put( chars[i], 1 );
			}
		
		}
		
		return charCounts;
		
	}
	
	private boolean compareCounts( Map<Character, Integer> counts1, Map<Character, Integer> counts2 ) {

		// if the keysets are different size, they cannot be angrams because at least one character is different
		if( counts1.keySet().size() != counts2.keySet().size() ) {
			return false;
		}
			
		// brute force check of characters
		for( Character c : counts1.keySet() ) {
			
			// if the character isnt present in the second string, they arent angrams 
			if( counts2.get( c ) == null ) {
				return false;
			}

			// if the counts on both characters are equal, continue to evaluate further
			// otherwise, bail because its not an angram
			if( counts2.get(c).equals( counts1.get(c) )) {
				// continue, this character is fine
			} else {
				// counts dont match, not an angram
				return false;
			}
		}
		
		// all characters exist in both sets with equivalent counts
		return true;
	}
	
	private void printCharCounts( Map<Character, Integer> charCounts ) {
		
		Iterator<Character> iter = charCounts.keySet().iterator();
		while( iter.hasNext() ) {
			
			Character c = iter.next();
			Integer count = charCounts.get( c );
			
			System.out.println( c + "\t\t\t" + count );
		}
		
	}
}
