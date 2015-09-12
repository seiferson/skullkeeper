package com.seifernet.skullkeeper.engine;

import java.util.ArrayList;

import com.seifernet.skullkeeper.persistence.dto.Comment;

/**
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 *
 */
public interface MicroblogManager {

	public void publishComment( Comment comment );
	
	public void editComment( Comment comment );
	
	public void deleteComment( Comment comment );
	
	public Comment getComment( Long id );
	
	public Comment getComment( String hash );
	
	public ArrayList<Comment> getComments( );
	
	public ArrayList<Comment> getComments( Long number );
	
	public ArrayList<Comment> getComments( Long page, Long pageSize );
	
	public ArrayList<Comment> getCommentsContaining( String hashtag );
	
	public ArrayList<Comment> getCommentsContaining( String hashtag, Long number );
	
	public ArrayList<Comment> getCommentsContaining( String hashtag, Long page, Long pageSize );
	
	public ArrayList<Comment> getCommentsAuthoredBy( String author );
	
	public ArrayList<Comment> getCommentsAuthoredBy( String author, Long number );
	
	public ArrayList<Comment> getCommentsAuthoredBy( String author, Long page, Long pageSize );
	
	public ArrayList<Comment> getCommentsMentioning( String author );
	
	public ArrayList<Comment> getCommentsMentioning( String author, Long number );
	
	public ArrayList<Comment> getCommentsMentioning( String author, Long page, Long pageSize );
	
	public ArrayList<String> getPopularHashtags(  );
	
	public ArrayList<String> getPopularHashtags( Long number );

}
