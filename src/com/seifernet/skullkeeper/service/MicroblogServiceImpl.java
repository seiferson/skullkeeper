package com.seifernet.skullkeeper.service;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.map.ObjectMapper;

import com.seifernet.skullkeeper.engine.MicroblogDatabaseManager;

@Path( "/microblog" )
public class MicroblogServiceImpl implements MicroblogService{
	
	/**
	 * @see 
	 */
	public Response publishPost( String data, String authorizationToken ){
		
		return Response.status( Status.OK ).build( );
	}
	
	public Response getPost( @PathParam( "hash" ) String hash ){
		String jsonData = "";
		
		try {
			jsonData = new ObjectMapper( ).writerWithDefaultPrettyPrinter( ).writeValueAsString( new MicroblogDatabaseManager( ).getComment( hash ) );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Response.status( Status.OK ).entity( jsonData ).build( );
	}
}
