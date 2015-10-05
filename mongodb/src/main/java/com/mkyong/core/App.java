package com.mkyong.core;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			
			
			
			DB testdb = mongo.getDB("testdb");
			
			
			DBCollection table = testdb.getCollection("user");
			BasicDBObject document = new BasicDBObject();
			document.put("name", "mkyong");
			document.put("age", 30);
			document.put("createdDate", new Date());
			document.put("blah", "is this ok");
			table.insert(document);
			
			
			List<String> dbs = mongo.getDatabaseNames();
			for(String db : dbs){
				System.out.println("printing"+db);
			}
			
			Set<String> tables = testdb.getCollectionNames();
			System.out.println("print tables"+ tables);
			
			for(String coll : tables){
				System.out.println(coll);
			}
			
			
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("name", "mkyong");

			DBCursor cursor = table.find(searchQuery);

			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
