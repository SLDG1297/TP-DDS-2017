package DB;

import com.mongodb.Block;
import com.mongodb.MongoClient;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public abstract class MongoDBManager {

    private MongoClient mongoClient = new MongoClient();

    private MongoDatabase cache = mongoClient.getDatabase("cache");

    public MongoCollection<Document> getCollectionMongo(String nombre){
        MongoCollection<Document> collection = cache.getCollection(nombre);
        return collection;
    }

    public String ejecutarQueryMongo(String nombreColecction, Bson consulta){
        Document doc = getCollectionMongo(nombreColecction).find(consulta).first();
        return doc.toJson();
    }

    public List<String> ejecutarQueryMongoReturnList(String nombreColecction, Bson consulta){
        List<String> lista = new ArrayList<String>();
        MongoCursor<Document> cursor = getCollectionMongo(nombreColecction).find(consulta).iterator();
        try {
            while (cursor.hasNext()) {
                lista.add(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }
        return lista;
    }

    public void addObjectMongo(String nombreColecction, Document doc){
        getCollectionMongo(nombreColecction).insertOne(doc);
    }

    public void addListMongo(String nombreColecction, List<Document> docs){
        getCollectionMongo(nombreColecction).insertMany(docs);
    }












}
