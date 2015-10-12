package com.seifernet.skullkeeper.security;

import com.seifernet.skullkeeper.persistence.dao.AccountDAO;
import com.seifernet.skullkeeper.persistence.dto.Account;

/**
 * 
 * @author seifer
 *
 */
public class AuthorizationService {
	
	public static boolean authenticate( String user, String passwd ){
		Account account = AccountDAO.getInstance( ).getAccount( user );
		
		if( account == null ){
			return false;
		}
		
		if( account.getPassword( ).equals( passwd ) ){
			return true;
		}
		
		return false;
	}
}
