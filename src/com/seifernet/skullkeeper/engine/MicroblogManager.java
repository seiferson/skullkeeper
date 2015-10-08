package com.seifernet.skullkeeper.engine;

import java.util.ArrayList;

import com.seifernet.skullkeeper.persistence.dto.Post;

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
	
	public void publishComment( Post comment );
	
	public void editComment( Post comment );
	
	public void deleteComment( Post comment );
	
	public Post getComment( String hash );
	
	public ArrayList<Post> getComments( int page, int pageSize );
	
	public ArrayList<Post> getCommentsContaining( String hashtag, int page, int pageSize );
	
	public ArrayList<Post> getCommentsAuthoredBy( String author, int page, int pageSize );

	public ArrayList<Post> getCommentsMentioning( String author, int page, int pageSize );
	
	public ArrayList<String> getPopularHashtags( int number );

}
