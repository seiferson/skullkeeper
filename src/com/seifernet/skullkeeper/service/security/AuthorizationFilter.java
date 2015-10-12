package com.seifernet.skullkeeper.service.security;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ServerResponse;

@Protected
@Provider
public class AuthorizationFilter implements ContainerRequestFilter{

	@Override
	public void filter( ContainerRequestContext requestContext ) throws IOException {
		
		MultivaluedMap<String, String> headers = requestContext.getHeaders( );
		
		List<String> authorizationHeader = headers.get( "Authorization" );
		
		System.out.println( "Ok" );
		
		requestContext.abortWith( new ServerResponse( "Authentication" , 401, new Headers<Object>( ) ) );
	}
	
}
