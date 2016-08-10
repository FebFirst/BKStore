package util;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import org.springframework.context.ApplicationContext; 
//import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import model.Mongo;
public class MongodbUtil {
	public static DB getMongodb(){ 
		ApplicationContext context = new GenericXmlApplicationContext(   
                "applicationContext.xml");
		Mongo mg = (Mongo)context.getBean("db");
		 MongoClient mongoClient = new MongoClient( mg.getUrl() ,mg.getPort());
		 DB db = mongoClient.getDB(mg.getSchema());  
		 return db;
	}
}
