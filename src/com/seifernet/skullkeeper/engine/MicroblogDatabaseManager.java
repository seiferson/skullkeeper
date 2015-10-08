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
		PostDAO.getInstance( ).insertComment( comment );
	}
	
	/**
	 * 
	 */
	public void editComment( Post comment ) {
		PostDAO.getInstance( ).editComment( comment );
		
	}
	
	/**
	 * 
	 */
	public void deleteComment( Post comment ) {
		PostDAO.getInstance( ).deleteComment( comment );
	}

	/**
	 * Retrieves a comment from database using
	 * its hash string as reference, returns null
	 * if not found
	 * 
	 * @return Comment from database if found
	 */
	public Post getComment( String hash ) {
		return PostDAO.getInstance( ).getComment( hash );
	}
	
	/**
	 * Retrieves a page of n comments published ordered 
	 * by date
	 * 
	 * @return List containing a k page with n comments published
	 */
	public ArrayList<Post> getComments( int page, int pageSize ) {
		return PostDAO.getInstance( ).getComments( page, pageSize );
	}

	/**
	 * 
	 */
	public ArrayList<Post> getCommentsContaining( String hashtag, int page, int pageSize ) {
		return PostDAO.getInstance( ).getCommentsContaining( hashtag, page, pageSize );
	}

	/**
	 * 
	 */
	public ArrayList<Post> getCommentsAuthoredBy( String author, int page, int pageSize ) {
		return PostDAO.getInstance( ).getCommentsAuthoredBy( author, page, pageSize );
	}
	
	/**
	 * 
	 */
	public ArrayList<Post> getCommentsMentioning( String authortag, int page, int pageSize ) {
		return PostDAO.getInstance().getCommentsMentioning( authortag, page, pageSize );
	}

	public ArrayList<String> getPopularHashtags( int number ) {
		return null;
	}

}
