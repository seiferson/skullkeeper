package com.seifernet.skullkeeper.persistence.dao;

import java.util.ArrayList;

import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.seifernet.skullkeeper.persistence.dto.Post;

/**
 * Post data access object
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 * 
 */
public class PostDAO extends GenericDAO{
	
	private static PostDAO instance;
	
	/**
	 * Constructor with call to parent constructor
	 * to create the morphia datastore.
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
	public void createPost( Post post ){
		
		datastore.save( post );
	}
	
	/**
	 * 
	 * @param post
	 */
	public void editPost( Post post ){
		Query<Post> query = datastore.createQuery( Post.class ).field( "id" ).equal( post.getId( ) );
		UpdateOperations<Post> operations = datastore.createUpdateOperations( Post.class )
				.set( "content", post.getContent( ) )
				.set( "hashtags", post.getHashtags( ) )
				.set( "usertags", post.getUsertags( ) )
				.set( "date" , post.getDate( ) );
		datastore.update( query, operations );
	}
	
	/**
	 * 
	 * @param post
	 */
	public void deletePost( Post post ){
		datastore.delete( post );
	}
	
	/**
	 * 
	 * @param hash
	 * @return
	 */
	public Post getPostByHash( String hash ){
		return datastore.createQuery( Post.class ).field( "hash" ).equal( hash ).asList( ).get( 0 );
	}
	
	/**
	 * 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public ArrayList<Post> getPosts( int page, int pageSize ){
		return new ArrayList<Post>( datastore.createQuery( Post.class ).limit( pageSize ).offset( page * pageSize ).asList( ) );
	}
	
	/**
	 * 
	 * @param hashtag
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public ArrayList<Post> getPostsContaining( String hashtag, int page, int pageSize ){
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
	public ArrayList<Post> getPostsAuthoredBy( String author, int page, int pageSize ){
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
	public ArrayList<Post> getPostsMentioning( String authortag, int page, int pageSize ){
		//ArrayList<Document> documents = collection.find( Filters.eq( "authortags.authortag",  authortag ) ).skip( page * pageSize ).limit( pageSize ).into( new ArrayList<Document>() );
		ArrayList<Post> comments = new ArrayList<Post>( );
		//for( Document d : documents ){
			//comments.add( PostAdapter.toPost( d ) );
		//}
		
		return comments;
	}
	
	
	
}
