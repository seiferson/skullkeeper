package com.seifernet.skullkeeper.persistence.dto;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * 
 * @author seifer
 *
 */
public class PostAdapter {
	
	/**
	 * 
	 * @param post
	 * @return
	 */
	public static Document toDocument( Post post ){
		Document postDocument = new Document( );
		Document authorDocument = new Document( );
		
		if( post.getId() != null ){
			postDocument.append( "_id" , new ObjectId( post.getId( ) ) );
		}
		
		authorDocument
			.append( "nickname" , post.getAuthor( ).getNickname( ) )
			.append( "identifier" , post.getAuthor( ).getIdentifier( ) )
			.append( "email" , post.getAuthor( ).getEmail( ) );
		
		postDocument
			.append( "date" , post.getDate( ) )
			.append( "content" , post.getContent( ) )
			.append( "hash", post.getHash( ) )
			.append( "author", authorDocument );
			
		ArrayList<Document> hashtags = new ArrayList<Document>( );
		for( String s : post.getHashtags( ) ){
			hashtags.add( new Document( ).append( "hashtag" , s ) );
		}
		
		postDocument.append( "hashtags" , hashtags );
		
		ArrayList<Document> authortags = new ArrayList<Document>( );
		for( String s: post.getAuthortags( ) ){
			authortags.add( new Document( ).append( "authortag" , s ) );
		}
		
		postDocument.append( "authortags", authortags );
		
		return postDocument;
	}
	
	/**
	 * 
	 * @param document
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Post toPost( Document document ){
		ObjectId id = document.get( "_id", ObjectId.class );
		
		Author author = new Author( );
		Document authorDocument = ( Document ) document.get( "author" );
		author.setEmail( authorDocument.getString( "nickname" ) );
		author.setIdentifier( authorDocument.getString( "identifier" ) );
		author.setEmail( authorDocument.getString( "email" ) );
		
		ArrayList<Document> documentHashtags = ( ArrayList<Document> ) document.get( "hashtags" );
		ArrayList<String> hashtags = new ArrayList<String>( );
		for( Document d : documentHashtags ){
			hashtags.add( d.getString( "hashtag" ) );
		}
		
		ArrayList<Document> documentAuthortags = ( ArrayList<Document> ) document.get( "authortags" );
		ArrayList<String> authortags = new ArrayList<String>( );
		for( Document d : documentAuthortags ){
			authortags.add( d.getString( "authortag" ) );
		}
		
		return new Post( 
			id == null ? "" : id.toString( ), 
			document.getDate( "date" ), 
			document.getString( "hash" ), 
			author, 
			document.getString( "content" ),
			hashtags,
			authortags
		);
		
	}

}
