package com.seifernet.skullkeeper.persistence.dao;

import com.seifernet.skullkeeper.persistence.dto.Author;

public class AuthorDAO extends GenericDAO<Author, Long>{

	public AuthorDAO(  ) {
		super( Author.class );
	}

}
