package com.seifernet.skullkeeper.engine;

import java.util.ArrayList;

import com.seifernet.skullkeeper.persistence.dao.PostDAO;
import com.seifernet.skullkeeper.persistence.dto.Post;

/**
 * Basic database microblog manager
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class MicroblogDatabaseManager implements MicroblogManager{

	/**
	 * 
	 */
	public void publishComment( Post comment ) {
		
	}
	
	public void editComment( Post comment ) {
		
		
	}

	public void deleteComment(Post comment) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Retrieves a comment from database using
	 * its hash string as reference, returns null
	 * if not found
	 * 
	 * @return Comment from database if found
	 */
	public Post getComment( String hash ) {
		return null;
	}
	
	/**
	 * Retrieves a page of n comments published ordered 
	 * by date
	 * 
	 * @return List containing a k page with n comments published
	 */
	public ArrayList<Post> getComments( int page, int pageSize ) {
		
		return null;
	}

	public ArrayList<Post> getCommentsContaining( String hashtag, int page, int pageSize ) {
		return null;
	}

	public ArrayList<Post> getCommentsAuthoredBy( String author, int page, int pageSize ) {
		return null;
	}
	
	public ArrayList<Post> getCommentsMentioning( String author, int page, int pageSize ) {
		return null;
	}
	
	public ArrayList<String> getPopularHashtags( ) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getPopularHashtags(int number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getCommentsMentioningCount(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
