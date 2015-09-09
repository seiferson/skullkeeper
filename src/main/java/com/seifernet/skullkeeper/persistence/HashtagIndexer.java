package com.seifernet.skullkeeper.persistence;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table( name="hashtag_index" )
public class HashtagIndexer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;

	private String hashtag;
	
	@ManyToMany
	@LazyCollection( LazyCollectionOption.FALSE )
	@JoinColumn( name="comments", referencedColumnName="id" )
	private ArrayList<Comment> comments;

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

	/**
	 * @return the comments
	 */
	public ArrayList<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
}
