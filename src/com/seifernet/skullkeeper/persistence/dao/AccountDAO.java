package com.seifernet.skullkeeper.persistence.dao;

import com.seifernet.skullkeeper.persistence.dto.Account;

public class AccountDAO extends GenericDAO{
	
	private static AccountDAO instance;
	
	private AccountDAO(  ){
		super( );
	}
	
	public static AccountDAO getInstance(  ){
		if( instance == null ){
			instance = new AccountDAO( );
		}
		return instance;
	}
	
	
	public Account getAccount( String nickname ){		
		return datastore.createQuery( Account.class ).field( "nickname" ).equal( nickname ).get( );
	}
	
	public void createAccount( Account account ){
		
	}
}
