package com.seifernet.skullkeeper.persistence.dao;

import java.net.UnknownHostException;

import org.jboss.logging.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.seifernet.skullkeeper.persistence.dto.Author;
import com.seifernet.skullkeeper.persistence.dto.Post;

/**
 * Generic MongoDB DAO
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class GenericDAO {

	private static final String DATABASE_SERVER 	= "localhost";
	private static final String DATABASE_NAME 		= "skullkeeper";
	
	private static final Logger logger 				= Logger.getLogger( GenericDAO.class );
	
	private MongoClient client;
	private Morphia morphia;
	protected Datastore datastore;
	
	/**
	 * 
	 */
	protected GenericDAO( ){
		morphia = new Morphia( );
		
		morphia.map( Post.class ).map( Author.class );
		try{
			client = new MongoClient( DATABASE_SERVER );
		} catch( UnknownHostException e ){
			logger.error( "Unknown host, error creating datastore" );
		}
		datastore = morphia.createDatastore( client , DATABASE_NAME );
	}
	
}
