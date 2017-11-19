package DB;

import com.mongodb.Block;
import com.mongodb.MongoClient;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public abstract class MongoDBManager {

//    MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
//    MongoClient mongoClient = new MongoClient(connectionString);

    private MongoClient mongoClient = new MongoClient();

    private MongoDatabase cache = mongoClient.getDatabase("cache");

    public MongoCollection<Document> getCollectionMongo(String nombre){
        MongoCollection<Document> collection = cache.getCollection(nombre);
        return collection;
    }

    public String ejecutarQueryMongo(String nombreColecction, Bson consulta){
        Document doc = getCollectionMongo(nombreColecction).find(consulta).first();
        String json = doc.toJson();
        System.out.println(json);
        return json;
    }

    public List<String> ejecutarQueryMongoReturnList(String nombreColecction, Bson consulta){
        List<String> lista = new ArrayList<String>();
        MongoCursor<Document> cursor = getCollectionMongo(nombreColecction).find(consulta).iterator();
        usoCursor(lista, cursor);
        return lista;
    }

    public void addObjectMongo(String nombreColecction, Document doc){
        getCollectionMongo(nombreColecction).insertOne(doc);
        System.out.println("Se agrego : " + doc.toJson());
    }

    public void addListMongo(String nombreColecction, List<Document> docs){
        for (Document doc : docs){
            getCollectionMongo(nombreColecction).insertOne(doc);
            System.out.println("Se agrego : " + doc.toJson());
        }
    }

    public List<String> getElementsColecction(String nombreColecction){
        List<String> lista = new ArrayList<String>();
        MongoCursor<Document> cursor = getCollectionMongo(nombreColecction).find().iterator();
        usoCursor(lista, cursor);
        return lista;
    }

    public void eliminarPorQuery(String nombreColecction, Bson consulta){
        DeleteResult deleteResult = getCollectionMongo(nombreColecction).deleteMany(consulta);
        System.out.println(deleteResult.getDeletedCount());
    }

    private void usoCursor(List<String> lista, MongoCursor<Document> cursor) {
        try {
            while (cursor.hasNext()) {
                String json = cursor.next().toJson();
                lista.add(json);
                System.out.println(json);
            }
        } finally {
            cursor.close();
        }
    }

}

