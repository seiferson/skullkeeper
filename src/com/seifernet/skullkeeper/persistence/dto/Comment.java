package com.seifernet.skullkeeper.persistence.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.google.gson.Gson;

/**
 * Comment is the basic data unit
 * in the microblog api, contains 
 * all the information about a specific post.
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Entity
@Table( name="microblog_comment" )
public class Comment implements Serializable{

	private static final long serialVersionUID = 1L;
	private static Pattern authortagPattern = Pattern.compile( "@\\S*" );
	private static Pattern hashtagPattern = Pattern.compile( "#\\S*" );
	
	@Id
	private Long id;
	
	private Date date;
	
	private String hash;
	
	private Author author;
	
	private String content;
	
	@ManyToMany
	@LazyCollection( LazyCollectionOption.FALSE )
	@JoinTable( name = "hashtag_index", 
		joinColumns = { @JoinColumn( name="comment", referencedColumnName="id" ) },  
		inverseJoinColumns = { @JoinColumn( name="hashtag", referencedColumnName="id") } ) 
	private List<Hashtag> hashtags;
	
	@ManyToMany
	@LazyCollection( LazyCollectionOption.FALSE )
	@JoinTable( name = "authortag_index", 
		joinColumns = { @JoinColumn( name="comment", referencedColumnName="id" ) },  
		inverseJoinColumns = { @JoinColumn( name="authortag", referencedColumnName="id") } ) 
	private List<Author> authortags;
	
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
	 * Get all the authortag strings from post content,
	 * a authortag is defined as any string that starts with
	 * an '@' symbol
	 * 
	 * @return A list with all the occurrences of authortags  
	 */
	public ArrayList<String> getContentAuthortags(  ){
		ArrayList<String> authortags = new ArrayList<String>( );
		Matcher matcher = authortagPattern.matcher( content );
		
		while( matcher.find( ) ){
			authortags.add( matcher.group( 0 ) );
		}
		
		return authortags;
	}
	
	/**
	 * Get all the hashtag strings from post content,
	 * a hashtag is defined as any string that starts with
	 * a '#' symbol
	 * 
	 * @return A list with all the occurrences of hashtags  
	 */
	public ArrayList<String> getContentHashtags(  ){
		ArrayList<String> hashtags = new ArrayList<String>( );
		Matcher matcher = hashtagPattern.matcher( content );
		
		while( matcher.find( ) ){
			hashtags.add( matcher.group( 0 ) );
		}
		
		return hashtags;
	}
	
	/**
	 * Creates a JSON formatted text version of the
	 * object 
	 * 
	 * @return JSON encoded string that represents the object
	 */
	public String toJSON(  ){
		Gson jsonConverter = new Gson( );
		
		return jsonConverter.toJson( this );
	}

	/**
	 * @return the hashtags
	 */
	public List<Hashtag> getHashtags() {
		return hashtags;
	}

	/**
	 * @param hashtags the hashtags to set
	 */
	public void setHashtags(List<Hashtag> hashtags) {
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
	public List<Author> getAuthortags() {
		return authortags;
	}

	/**
	 * @param authortags the authortags to set
	 */
	public void setAuthortags(List<Author> authortags) {
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
