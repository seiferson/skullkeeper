package com.seifernet.skullkeeper;

import java.util.Date;

import com.seifernet.skullkeeper.persistence.Comment;

public class Enviroment {

	
	public static void main( String[ ] args ) {
		Comment comment =  new Comment( );
		comment.setAuthor( "seifer" );
		comment.setContent( "#thisisapost #fuckthepolice hey i'm here @seifer" );
		comment.setDate( new Date( ) );
		comment.setId( 123L );
		
		System.out.println( comment.toJSON( ) );
		for( String x : comment.getContentHashtags( ) ){
			System.out.println( x );
		}
		
		for( String x : comment.getContentAuthortags( ) ){
			System.out.println( x );
		}
	}
}
