package com.seifernet.skullkeeper.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.seifernet.skullkeeper.engine.MicroblogDatabaseManager;
import com.seifernet.skullkeeper.persistence.dto.Post;

@Path( "/microblog" )
public class Service {
	
	@Path( "/comments" )
	@POST
	@Consumes( "application/json;charset=UTF-8"	)
	public Response publishComment( @FormParam( "data" ) String comment ){
		
		
		return Response.status( Status.OK ).build( );
	}
	
	@Path( "/comments/{hash}" )
	@GET
	@Produces( "application/json;charset=UTF-8" )
	public Post getComment( @PathParam( "hash" ) String hash ){
		return new MicroblogDatabaseManager( ).getComment( hash );
	}
}
