package com.seifernet.skullkeeper.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="microblog_authortag" )
public class Authortag implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String authortag;

	/**
	 * @return the id
	 */
	public Long getId( ) {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the authortag
	 */
	public String getAuthortag() {
		return authortag;
	}

	/**
	 * @param authortag the authortag to set
	 */
	public void setAuthortag(String authortag) {
		this.authortag = authortag;
	}

	
}
