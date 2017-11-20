package DB.TiposDeRepositorios;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

public interface RepoDocumental {

//    public MongoCollection<Document> getCollection();
//
//    public void setCollection(MongoCollection<Document> collection);

    public Object jsonToObjeto(String json);

    public String getTabla();

    public Document crearDocument(Object object);
}
