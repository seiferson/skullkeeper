package com.seifernet.skullkeeper.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.seifernet.skullkeeper.engine.MicroblogDatabaseManager;
import com.seifernet.skullkeeper.persistence.dto.Comment;

/**
 * 
 * @author seifer
 *
 */
@Path( "/microblog" )
@Consumes( { "application/json" } )
@Produces( { "application/json" } )
public class Skullkeeper {

	@GET
	@Path( "/comments" )
	public Response getCommments(  ){
		Gson jsonConverter = new Gson( );
		MicroblogDatabaseManager manager = new MicroblogDatabaseManager( );
		
		return Response.status( 200 ).entity( jsonConverter.toJson( manager.getComments( ) ) ).build( );
	}
	
	@POST
	@Path( "/comments" )
	public Response setComment( @FormParam( "data" ) String data ){
		Gson jsonConverter = new Gson( );
		Comment comment = jsonConverter.fromJson( data, Comment.class );
		MicroblogDatabaseManager manager = new MicroblogDatabaseManager( );
		
		manager.publishComment( comment );
		
		return Response.status( 200 ).build( );
	}

}
