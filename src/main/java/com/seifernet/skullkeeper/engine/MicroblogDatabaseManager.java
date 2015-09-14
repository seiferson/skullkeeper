package com.seifernet.skullkeeper.engine;

import java.util.ArrayList;

import com.seifernet.skullkeeper.persistence.dao.AuthorDAO;
import com.seifernet.skullkeeper.persistence.dao.CommentDAO;
import com.seifernet.skullkeeper.persistence.dao.HashtagDAO;
import com.seifernet.skullkeeper.persistence.dto.Author;
import com.seifernet.skullkeeper.persistence.dto.Comment;
import com.seifernet.skullkeeper.persistence.dto.Hashtag;

/**
 * Basic database microblog manager, uses
 * hibernate criteria to create, edit an retrieve
 * comments from database.
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class MicroblogDatabaseManager implements MicroblogManager{

	public void publishComment( Comment comment ) {
		
		//Hashtags check
		ArrayList<String> contentHashtags = comment.getContentHashtags( );
		if( contentHashtags.size() != 0 ){
			ArrayList<Hashtag> hashtagList = new ArrayList<Hashtag>( );
			HashtagDAO hdao = new HashtagDAO( );
			for( String hashtag : contentHashtags ){
				Hashtag h = hdao.read( "hashtag" , hashtag );
				
				//Validate hashtag existence in db
				if( h == null ){
					h = new Hashtag( );
					h.setHashtag( hashtag );
					hdao.create( h );
					hashtagList.add( h );
				}
				hashtagList.add( h );
			}
			comment.setHashtags( hashtagList );
		}
		
		//Authortags check
		ArrayList<String> contentAuthortags = comment.getContentAuthortags( );
		if( contentAuthortags.size( ) != 0 ){
			ArrayList<Author> authortagList = new ArrayList<Author>( );
			AuthorDAO adao = new AuthorDAO( );
			for( String author : contentAuthortags ){
				Author a = adao.read( "author" , author.substring( 1 ) );
				
				//Validate author existence in db
				if( a != null ){
					authortagList.add( a );
				}
			}
			comment.setAuthortags( authortagList );
		}
		
		CommentDAO dao = new CommentDAO( );
		dao.create( comment );
	}

	/**
	 * Retrieves a comment from database using
	 * its ID as reference, returns null
	 * if not found
	 * 
	 * @return Comment from database if found
	 */
	public Comment getComment( Long id ) {
		CommentDAO dao = new CommentDAO( );

		return dao.read( id );
	}

	/**
	 * Retrieves a comment from database using
	 * its hash string as reference, returns null
	 * if not found
	 * 
	 * @return Comment from database if found
	 */
	public Comment getComment( String hash ) {
		CommentDAO dao = new CommentDAO( );
		
		return dao.read( "hash" , hash );
	}

	/**
	 * Retrieves the latest 10 comments published
	 * ordered by date
	 * 
	 * @return List containing latest 10 comments published
	 */
	public ArrayList<Comment> getComments( ) {
		CommentDAO dao = new CommentDAO( );
		
		return new ArrayList<Comment>( dao.readAllDsc( "date" , 10 ) );
	}

	/**
	 * Retrieves the latest N comments published on
	 * database ordered by date
	 * 
	 * @return List containing the latest N comments published
	 */
	public ArrayList<Comment> getComments( int number ) {
		CommentDAO dao = new CommentDAO( );
		
		return new ArrayList<Comment>( dao.readAllDsc( "date" , number ) );
	}
	
	/**
	 * Retrieves a page of n comments published ordered 
	 * by date
	 * 
	 * @return List containing a k page with n comments published
	 */
	public ArrayList<Comment> getComments( int page, int pageSize ) {
		CommentDAO dao = new CommentDAO( );
		
		return new ArrayList<Comment>( dao.readAll( page, pageSize ) );
	}
	
	/**
	 * Retrieves the total number of comments published
	 * 
	 * @return Number of comments published
	 */
	public Long getCommentsCount( ) {
		CommentDAO dao = new CommentDAO( );
		
		return dao.getCount( );
	}

	
	public ArrayList<Comment> getCommentsContaining(String hashtag) {
		CommentDAO dao = new CommentDAO( );
		return null;
	}

	public ArrayList<Comment> getCommentsContaining(String hashtag, int number) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Comment> getCommentsContaining(String hashtag, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Comment> getCommentsAuthoredBy(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Comment> getCommentsAuthoredBy(String author, int number) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Comment> getCommentsAuthoredBy(String author, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Comment> getCommentsMentioning(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Comment> getCommentsMentioning(String author, int number) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Comment> getCommentsMentioning(String author, int page, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getPopularHashtags() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getPopularHashtags(int number) {
		// TODO Auto-generated method stub
		return null;
	}

	public void editComment( Comment comment ) {
		
		
	}

	public void deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		
	}

	public Long getCommentsContainingCount(String hashtag) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getCommentsAuthoredCount(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getCommentsMentioningCount(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
