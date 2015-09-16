package com.seifernet.skullkeeper.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.seifernet.skullkeeper.persistence.dto.Comment;

public class CommentDAO extends GenericDAO<Comment, Long>{

	public CommentDAO( ) {
		super( Comment.class );
	}
	
	@SuppressWarnings("unchecked")
	public List<Comment> getComments( int pageSize, int page ){
		List<Comment> comments = null;
		Session session = getSession( );
		Transaction transaction = session.beginTransaction( );

		comments = session.
				createCriteria( Comment.class ).
				setMaxResults( page ).
				setFirstResult( page * pageSize ).
				addOrder( Order.desc( "date" ) ).
				list( );
		transaction.commit( );
		return comments;
	}

	public Long getCommentsCount( ) {
		Long count = null;
		Session session = getSession( );
		Transaction transaction = session.beginTransaction( );
		
		count = ( Long )session.
				createCriteria( Comment.class ).
				setProjection( Projections.rowCount( ) ).
				uniqueResult( );
		transaction.commit( );
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentsContaining( String hashtag, int page, int pageSize ){
		List<Comment> comments = null;
		Session session = getSession( );
		Transaction transaction = session.beginTransaction( );

		comments = session.
				createCriteria( Comment.class ).
				createAlias( "hashtags" , "h" ).
				add( Restrictions.eq( "h.hashtag" , hashtag ) ).
				setMaxResults( page ).
				setFirstResult( page * pageSize ).
				addOrder( Order.desc( "date" ) ).
				list( );
		transaction.commit( );
		return comments;
	}
	
	public Long getCommentsContainingCount( String hashtag ) {
		Long count = null;
		Session session = getSession( );
		Transaction transaction = session.beginTransaction( );
		
		count = ( Long )session.
				createCriteria( Comment.class ).
				createAlias( "hashtags" , "h" ).
				add( Restrictions.eq( "h.hashtag" , hashtag ) ).
				setProjection( Projections.rowCount( ) ).
				uniqueResult( );
		transaction.commit( );
		return count;
	}
	
	@SuppressWarnings("unchecked")
	public List<Comment> getCommentsAuthoredBy( String author, int page, int pageSize ){
		List<Comment> comments = null;
		Session session = getSession( );
		Transaction transaction = session.beginTransaction( );

		comments = session.
				createCriteria( Comment.class ).
				createAlias( "author" , "a" ).
				add( Restrictions.eq( "a.author" , author ) ).
				setMaxResults( page ).
				setFirstResult( page * pageSize ).
				addOrder( Order.desc( "date" ) ).
				list( );
		transaction.commit( );
		return comments;
	}
	
	public Long getCommentsAuthoredCount( String author ){
		Long count = null;
		Session session = getSession( );
		Transaction transaction = session.beginTransaction( );
		
		count = ( Long )session.
				createCriteria( Comment.class ).
				createAlias( "author" , "a" ).
				add( Restrictions.eq( "a.author" , author ) ).
				setProjection( Projections.rowCount( ) ).
				uniqueResult( );
		transaction.commit( );
		return count;
	}

	@SuppressWarnings("unchecked")
	public List<Comment> getCommentsMentioning( String author, int page, int pageSize ) {
		List<Comment> comments = null;
		Session session = getSession( );
		Transaction transaction = session.beginTransaction( );

		comments = session.
				createCriteria( Comment.class ).
				createAlias( "authortags" , "a" ).
				add( Restrictions.eq( "a.author" , author ) ).
				setMaxResults( page ).
				setFirstResult( page * pageSize ).
				addOrder( Order.desc( "date" ) ).
				list( );
		transaction.commit( );
		return comments;
	}
	
	public Long getCommentsMentioningCount( String author ){
		Long count = null;
		Session session = getSession( );
		Transaction transaction = session.beginTransaction( );
		
		count = ( Long )session.
				createCriteria( Comment.class ).
				createAlias( "authortags" , "a" ).
				add( Restrictions.eq( "a.author" , author ) ).
				setProjection( Projections.rowCount( ) ).
				uniqueResult( );
		transaction.commit( );
		return count;
	}

	
	
}
