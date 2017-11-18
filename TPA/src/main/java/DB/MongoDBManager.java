package DB;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

public abstract class MongoDBManager {

    private MongoClient mongoClient = new MongoClient();

    private MongoDatabase cache = mongoClient.getDatabase("cache");

    public MongoCollection<Document> crearColeccionMongo(String nombre){
        MongoCollection<Document> collection = cache.getCollection(nombre);
        return collection;
    }








}
