package com.seifernet.skullkeeper.persistence.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Basic data unit in the microblog api, contains 
 * all the information about a specific post.
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 */
@Entity
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	
	private Date date;
	
	private String hash;
	
	@Embedded
	private Author author;
	
	private String content;
	
	private ArrayList<String> hashtags;
	
	private ArrayList<String> authortags;
	
	public Post(  ){
		
	}
	
	public Post(String id, Date date, String hash, Author author, String content, ArrayList<String> hashtags,
			ArrayList<String> authortags) {
		super();
		this.id = id;
		this.date = date;
		this.hash = hash;
		this.author = author;
		this.content = content;
		this.hashtags = hashtags;
		this.authortags = authortags;
	}
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * @param content the content to set
	 */
	public void setContent( String content ) {
		this.content = content;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the hashtags
	 */
	public ArrayList<String> getHashtags() {
		return hashtags;
	}

	/**
	 * @param hashtags the hashtags to set
	 */
	public void setHashtags(ArrayList<String> hashtags) {
		this.hashtags = hashtags;
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
	 * @return the authortags
	 */
	public ArrayList<String> getAuthortags() {
		return authortags;
	}

	/**
	 * @param authortags the authortags to set
	 */
	public void setAuthortags(ArrayList<String> authortags) {
		this.authortags = authortags;
	}

	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	
}
