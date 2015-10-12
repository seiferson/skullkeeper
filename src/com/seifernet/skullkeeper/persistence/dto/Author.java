package com.seifernet.skullkeeper.persistence.dto;

import java.io.Serializable;

import org.mongodb.morphia.annotations.Embedded;

/**
 * Comment's author data
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@Embedded
public class Author implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nickname;
	
	private String identifier;
	
	private String email;

	public Author( ){
		
	}
	
	public Author(String nickname, String identifier, String email) {
		this.nickname = nickname;
		this.identifier = identifier;
		this.email = email;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
