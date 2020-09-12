package com.example.MPloin.Repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
@Repository
public class MongoClientRepository {

	MongoClient mongoClient;
	
	MongoClient getMongoClient() {
		if (mongoClient == null)
		{
			mongoClient = new MongoClient("localhost", 27017);
		}
		return mongoClient;
	}
	
	public List<Object> findAll() {
		MongoClient mongoclient = getMongoClient();
		MongoDatabase mongoDatabase = mongoclient.getDatabase("mploin");
		MongoCollection<Document> collection = mongoDatabase.getCollection("employee");
		
		Iterable<Document> findDocuments = collection.find();
		
		List<Object> responseObject = new ArrayList<Object>();
		
		for(Document doc :  findDocuments) {
			responseObject.add(doc);
		}
		
		return responseObject;	
	}
}
