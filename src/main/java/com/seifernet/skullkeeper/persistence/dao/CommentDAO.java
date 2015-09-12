package com.seifernet.skullkeeper.persistence.dao;

import com.seifernet.skullkeeper.persistence.dto.Comment;

public class CommentDAO extends GenericDAO<Comment, Long>{

	public CommentDAO( ) {
		super( Comment.class );
	}

}
