package com.seifernet.skullkeeper.persistence.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.seifernet.skullkeeper.persistence.dto.Comment;

public class CommentDAO extends GenericDAO<Comment, Long>{

	public CommentDAO( ) {
		super( Comment.class );
	}
	
	@SuppressWarnings("unchecked")
	public List<Comment> readAll( int pageSize, int page ){
		Transaction 	transaction = null;
		Session 		session 	= null;
		List<Comment>	object		= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		object = session.createCriteria( Comment.class ).setMaxResults( page ).setFirstResult( page * pageSize ).list( );
		transaction.commit( );
		return object;
	}

	public Long getCount( ) {
		Transaction transaction = null;
		Session 	session 	= null;
		Long		object		= null;
		
		session = getSession( );
		transaction = session.beginTransaction( );
		object = ( Long ) session.createCriteria( Comment.class ).setProjection( Projections.rowCount( ) ).uniqueResult( );
		transaction.commit( );
		return object;
	}

}
