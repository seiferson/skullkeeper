package com.seifernet.skullkeeper.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name="authortag_index" )
public class AuthortagIndexer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	@OneToOne
	@JoinColumn( name="author", referencedColumnName="id" )
	private Author author;
	
	@OneToOne
	@JoinColumn( name="comment", referencedColumnName="id" )
	private Comment comment;

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
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	/**
	 * @return the comment
	 */
	public Comment getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
}
