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

public class PostDAO {
	
	private static PostDAO instance;
	private MongoClient client;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	private PostDAO( ){
		client = new MongoClient( "localhost" );
		database = client.getDatabase( "skullkeeper" );
		collection = database.getCollection( "post" );
	}
	
	public static PostDAO getInstance(  ){
		if( instance == null ){
			instance = new PostDAO( );
		}
		return instance;
	}
	
	public void insertComment( Post post ){
		collection.insertOne( PostAdapter.toDocument( post ) );
	}
	
	public void editComment( Post post ){
		collection.replaceOne( Filters.eq( "_id", new ObjectId( post.getId( ) ) ), PostAdapter.toDocument( post ) );
	}
	
	public void deleteComment( Post post ){
		collection.deleteOne( Filters.eq( "_id", new ObjectId( post.getId( ) ) ) );
	}
	
	public Post getComment( String hash ){
		return PostAdapter.toPost( collection.find( Filters.eq( "hash", hash ) ).first( ) );
	}
	
	public ArrayList<Post> getComments( int page, int pageSize ){
		ArrayList<Document> documents = collection.find(  ).skip( page * pageSize ).limit( pageSize ).into( new ArrayList<Document>() );
		ArrayList<Post> comments = new ArrayList<Post>( );
		for( Document d : documents ){
			comments.add( PostAdapter.toPost( d ) );
		}
		
		return comments;
	}
	
	public ArrayList<Post> getCommentsContaining( String hashtag, int page, int pageSize ){
		ArrayList<Document> documents = collection.find( Filters.eq( "hashtags.hashtag" ,  hashtag ) ).skip( page * pageSize ).limit( pageSize ).into( new ArrayList<Document>() );
		ArrayList<Post> comments = new ArrayList<Post>( );
		for( Document d : documents ){
			comments.add( PostAdapter.toPost( d ) );
		}
		
		return comments;
	}
	
	
	
}
