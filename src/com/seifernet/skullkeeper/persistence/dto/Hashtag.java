package com.seifernet.skullkeeper.persistence.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="microblog_hashtag" )
public class Hashtag implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;

	private String hashtag;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the hashtag
	 */
	public String getHashtag() {
		return hashtag;
	}

	/**
	 * @param hashtag the hashtag to set
	 */
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
}
