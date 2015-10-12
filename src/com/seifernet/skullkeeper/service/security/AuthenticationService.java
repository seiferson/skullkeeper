package com.seifernet.skullkeeper.service.security;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface AuthenticationService {

	/**
	 * 
	 * @param user
	 * @param param
	 * @return
	 */
	@POST
	@Produces( "application/json" )
	public Response generateToken( @FormParam( "user" ) String user, @FormParam( "passwd" ) String param );
	
	

}
