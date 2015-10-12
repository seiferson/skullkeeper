package com.seifernet.skullkeeper.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.seifernet.skullkeeper.service.security.Protected;

/**
 * Basic microblog operations for REST service.
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 */
public interface MicroblogService {
	
	/**
	 * Method used to publish a comment, it expects
	 * the authorization token and a JSON encoded
	 * string as a form parameter containing the post
	 * content, content supports UTF-8 strings, hashtags
	 * ( strings starting with a # char ) and usertags
	 * ( strings starting with an @ char ).
	 * 
	 * 
	 * REST specs
	 * url: skullkeeper/api/microblog/post
	 * method: POST
	 * headers: Authorization: Bearer <token>
	 * params:
	 *     form( data )
	 *     { 
	 *         "post" : "<postcontent>"
 	 *     }
 	 *     
	 * @param data JSON encoded 
	 * @return Server response
	 */
	@Path( "/post" )
	@POST
	@Protected
	@Consumes( "application/json;charset=UTF-8"	)
	public Response publishPost( @FormParam( "data" ) String data, @HeaderParam( "Authorization" ) String authorizationToken );
	
	/**
	 * Method used to retrieve an specific post using
	 * it's hash idenfier. Hash is a 64 char unique string.
	 * 
	 * REST specs
	 * url: skullkeeper/api/microblog/post/<hash>
	 * method: GET
	 * headers: None
	 * params:
	 *     get( hash ) 
	 *     URL/<hash>
	 * 
	 * @param hash 
	 * @return Server response with JSON encoded post on body
	 */
	@Path( "/post/{hash}" )
	@GET
	@Produces( "application/json;charset=UTF-8" )
	public Response getPost( @PathParam( "hash" ) String hash );
}
