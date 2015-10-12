package com.seifernet.skullkeeper.util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 *
 */
public abstract class PostProcessor {
	
	private static Pattern authortagPattern = Pattern.compile( "@\\S*" );
	private static Pattern hashtagPattern = Pattern.compile( "#\\S*" );
	
	/**
	 * Get all the authortag strings from post content,
	 * a authortag is defined as any string that starts with
	 * an '@' symbol
	 * 
	 * @return A list with all the occurrences of authortags  
	 */
	public ArrayList<String> getContentAuthortags( String content ){
		ArrayList<String> authortags = new ArrayList<String>( );
		Matcher matcher = authortagPattern.matcher( content );
		
		while( matcher.find( ) ){
			authortags.add( matcher.group( 0 ) );
		}
		
		return authortags;
	}
	
	/**
	 * Get all the hashtag strings from post content,
	 * a hashtag is defined as any string that starts with
	 * a '#' symbol
	 * 
	 * @return A list with all the occurrences of hashtags  
	 */
	public ArrayList<String> getContentHashtags( String content ){
		ArrayList<String> hashtags = new ArrayList<String>( );
		Matcher matcher = hashtagPattern.matcher( content );
		
		while( matcher.find( ) ){
			hashtags.add( matcher.group( 0 ) );
		}
		
		return hashtags;
	}

}
