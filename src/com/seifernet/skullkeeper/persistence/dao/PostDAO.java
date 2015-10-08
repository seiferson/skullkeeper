package com.seifernet.skullkeeper.persistence.dao;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.seifernet.skullkeeper.persistence.dto.Post;
import com.seifernet.skullkeeper.persistence.dto.PostAdapter;

/**
 * 
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 */
public class PostDAO {
	
	public static final String DATABASE_SERVER 	= "localhost";
	public static final String DATABASE_NAME 	= "skullkeeper";
	
	private static PostDAO instance;
	
	private MongoClient client;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	/**
	 * 
	 */
	private PostDAO( ){
		client = new MongoClient( DATABASE_SERVER );
		database = client.getDatabase( DATABASE_NAME );
		collection = database.getCollection( "post" );
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
		collection.insertOne( PostAdapter.toDocument( post ) );
	}
	
	/**
	 * 
	 * @param post
	 */
	public void editComment( Post post ){
		collection.replaceOne( Filters.eq( "_id", new ObjectId( post.getId( ) ) ), PostAdapter.toDocument( post ) );
	}
	
	/**
	 * 
	 * @param post
	 */
	public void deleteComment( Post post ){
		collection.deleteOne( Filters.eq( "_id", new ObjectId( post.getId( ) ) ) );
	}
	
	/**
	 * 
	 * @param hash
	 * @return
	 */
	public Post getComment( String hash ){
		return PostAdapter.toPost( collection.find( Filters.eq( "hash", hash ) ).first( ) );
	}
	
	/**
	 * 
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public ArrayList<Post> getComments( int page, int pageSize ){
		ArrayList<Document> documents = collection.find(  ).skip( page * pageSize ).limit( pageSize ).into( new ArrayList<Document>() );
		ArrayList<Post> comments = new ArrayList<Post>( );
		for( Document d : documents ){
			comments.add( PostAdapter.toPost( d ) );
		}
		
		return comments;
	}
	
	/**
	 * 
	 * @param hashtag
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public ArrayList<Post> getCommentsContaining( String hashtag, int page, int pageSize ){
		ArrayList<Document> documents = collection.find( Filters.eq( "hashtags.hashtag" ,  hashtag ) ).skip( page * pageSize ).limit( pageSize ).into( new ArrayList<Document>() );
		ArrayList<Post> comments = new ArrayList<Post>( );
		for( Document d : documents ){
			comments.add( PostAdapter.toPost( d ) );
		}
		
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
		ArrayList<Document> documents = collection.find( Filters.eq( "author.identifier",  author ) ).skip( page * pageSize ).limit( pageSize ).into( new ArrayList<Document>() );
		ArrayList<Post> comments = new ArrayList<Post>( );
		for( Document d : documents ){
			comments.add( PostAdapter.toPost( d ) );
		}
		
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
		ArrayList<Document> documents = collection.find( Filters.eq( "authortags.authortag",  authortag ) ).skip( page * pageSize ).limit( pageSize ).into( new ArrayList<Document>() );
		ArrayList<Post> comments = new ArrayList<Post>( );
		for( Document d : documents ){
			comments.add( PostAdapter.toPost( d ) );
		}
		
		return comments;
	}
	
	
	
}
