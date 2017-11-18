package DB.Proveedores;

import DB.MongoDBManager;
import DB.TiposDeRepositorios.TipoDeRepositorio;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
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

import java.lang.reflect.Type;
import java.util.List;

public class ProveedorMongoDB<T extends TipoDeRepositorio> extends MongoDBManager implements Proveedor<T> {

    public ProveedorMongoDB() {super();}

    private MongoCollection<Document> collection = null;

    private void comprobarCollection(String unTipo){
        if(collection == null)
        { collection = crearColeccion(unTipo);}
    }

    private Object jsonToObjeto(String json,String unTipo) throws ClassNotFoundException {
        Gson gson = new Gson();
        Class c = Class.forName(unTipo);
        return gson.fromJson(json, c.getClass());
    }
    @Override
    public T darObjeto(String unNombre, String unTipo) {
        this.comprobarCollection(unTipo);
        return null;
    }

    @Override
    public List<T> darLista(String unTipo) {
        this.comprobarCollection(unTipo);
        List<Object> lista = new ArrayList<Object>();
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
               String o = cursor.next().toJson();
               Object objeto = this.jsonToObjeto(o,unTipo);
               lista.add(objeto);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }
        return (List<T>) lista;
    }

    @Override
    public List<String> darListaNombres(String unTipo) {
        this.comprobarCollection(unTipo);
        return null;
    }

    @Override
    public void agregar(T unObjeto) {
        collection.insertOne((Document) unObjeto);
    }

    @Override
    public void agregarLista(List<T> listaObjetos) {
        collection.insertMany((List<? extends Document>) listaObjetos);
    }

    @Override
    public void modificar(T unObjeto) {

    }

    @Override
    public void eliminar(T unObjeto) {

    }
}
