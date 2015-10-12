package com.seifernet.skullkeeper.persistence.dao;

import java.util.ArrayList;

import com.seifernet.skullkeeper.persistence.dto.Post;

/**
 * 
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 */
public class PostDAO extends GenericDAO{
	
	private static PostDAO instance;
	
	/**
	 * 
	 */
	private PostDAO( ){
		super( );
	}
	
	/**
	 * 
	 * @return
	 */
	public static PostDAO getInstance(  ){
		if( instance == null ){
			instance = new PostDAO( );
		}
		return instance;
	}
	
	/**
	 * 
	 * @param post
	 */
	public void insertComment( Post post ){
		datastore.save( post );
	}
	
	/**
	 * 
	 * @param post
	 */
	public void editComment( Post post ){
		//datastore.( Filters.eq( "_id", new ObjectId( post.getId( ) ) ), PostAdapter.toDocument( post ) );
	}
	
	/**
	 * 
	 * @param post
	 */
	public void deleteComment( Post post ){
		datastore.delete( post );
	}
	
	/**
	 * 
	 * @param hash
	 * @return
	 */
	public Post getComment( String hash ){
		return datastore.createQuery( Post.class ).field( "hash" ).equal( hash ).asList( ).get( 0 );
	}
	
	/**
	 * 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public ArrayList<Post> getComments( int page, int pageSize ){
		return new ArrayList<Post>( datastore.createQuery( Post.class ).limit( pageSize ).offset( page * pageSize ).asList( ) );
	}
	
	/**
	 * 
	 * @param hashtag
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public ArrayList<Post> getCommentsContaining( String hashtag, int page, int pageSize ){
		//ArrayList<Document> documents = collection.find( Filters.eq( "hashtags.hashtag" ,  hashtag ) ).skip( page * pageSize ).limit( pageSize ).into( new ArrayList<Document>() );
		ArrayList<Post> comments = new ArrayList<Post>( );
		//for( Document d : documents ){
			//comments.add( PostAdapter.toPost( d ) );
		//}
		
		return comments;
	}
	
	/**
	 * 
	 * @param author
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public ArrayList<Post> getCommentsAuthoredBy( String author, int page, int pageSize ){
		//ArrayList<Document> documents = collection.find( Filters.eq( "author.identifier",  author ) ).skip( page * pageSize ).limit( pageSize ).into( new ArrayList<Document>() );
		ArrayList<Post> comments = new ArrayList<Post>( );
		//for( Document d : documents ){
			//comments.add( PostAdapter.toPost( d ) );
		//}
		
		return comments;
	}
	
	/**
	 * 
	 * @param authortag
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public ArrayList<Post> getCommentsMentioning( String authortag, int page, int pageSize ){
		//ArrayList<Document> documents = collection.find( Filters.eq( "authortags.authortag",  authortag ) ).skip( page * pageSize ).limit( pageSize ).into( new ArrayList<Document>() );
		ArrayList<Post> comments = new ArrayList<Post>( );
		//for( Document d : documents ){
			//comments.add( PostAdapter.toPost( d ) );
		//}
		
		return comments;
	}
	
	
	
}
