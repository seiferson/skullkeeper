package com.seifernet.skullkeeper.engine;

import java.util.ArrayList;

import com.seifernet.skullkeeper.persistence.dto.Comment;

/**
 * Defines basic operations that every microblog manager
 * must implement.
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface MicroblogManager {
	
	public void publishComment( Comment comment );
	
	public void editComment( Comment comment );
	
	public void deleteComment( Comment comment );
	
	public Comment getComment( Long id );
	
	public Comment getComment( String hash );
	
	public ArrayList<Comment> getComments( );
	
	public ArrayList<Comment> getComments( int number );
	
	public Long getCommentsCount(  );
	
	public ArrayList<Comment> getComments( int page, int pageSize );
	
	public ArrayList<Comment> getCommentsContaining( String hashtag );
	
	public ArrayList<Comment> getCommentsContaining( String hashtag, int number );
	
	public ArrayList<Comment> getCommentsContaining( String hashtag, int page, int pageSize );
	
	public Long getCommentsContainingCount( String hashtag );
	
	public ArrayList<Comment> getCommentsAuthoredBy( String author );
	
	public ArrayList<Comment> getCommentsAuthoredBy( String author, int number );
	
	public ArrayList<Comment> getCommentsAuthoredBy( String author, int page, int pageSize );
	
	public Long getCommentsAuthoredCount( String author );
	
	public ArrayList<Comment> getCommentsMentioning( String author );
	
	public ArrayList<Comment> getCommentsMentioning( String author, int number );
	
	public ArrayList<Comment> getCommentsMentioning( String author, int page, int pageSize );
	
	public Long getCommentsMentioningCount( String author );
	
	public ArrayList<String> getPopularHashtags(  );
	
	public ArrayList<String> getPopularHashtags( int number );

}
