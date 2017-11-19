package DB.Proveedores;

import DB.MongoDBManager;
import DB.Repositorios.Repositorio;
import DB.TiposDeRepositorios.RepoDocumental;
import DB.TiposDeRepositorios.TipoDeRepositorio;
import Modelo.Indicadores.Precalculado;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import com.mongodb.client.MongoCursor;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

public class ProveedorMongoDB<T extends TipoDeRepositorio> extends MongoDBManager implements Proveedor<T> {

    private RepoDocumental repoMongo;

    public ProveedorMongoDB(RepoDocumental repoMongo) {
        this.repoMongo = repoMongo;
    }

    @Override
    public T ejecutarQuery(Object query) {
        String json = ejecutarQueryMongo(repoMongo.getTabla(), (Bson) query);
        return (T) repoMongo.jsonToObjeto(json);
    }

    @Override
    public List<T> EjecutarQueryReturnList(Object query) {
        List<String> list = ejecutarQueryMongoReturnList(repoMongo.getTabla(), (Bson) query);
        List<T> lista = new ArrayList<T>();
        for(String json : list){
            lista.add((T) repoMongo.jsonToObjeto(json));
        }
        return lista;
    }

    @Override
    public List<T> darLista(String unTipo) {
        List<T> lista = new ArrayList<>();
        MongoCursor<Document> cursor = getCollectionMongo(unTipo).find().iterator();
        try {
            while (cursor.hasNext()) {
                String o = cursor.next().toJson();
                T objeto = (T) this.repoMongo.jsonToObjeto(o);
                lista.add(objeto);
            }
        } finally {
            cursor.close();
        }
        return lista;
    }

    @Override
    public void agregar(T unObjeto) {/*Se sobreescribe, se recibe un Obj Precalculado, y aca dentro se crea un Obj Document y este Document se pasar por parametro al super*/
        //Aca Descomponer Obj Precalculado, crear document, y llenarlo con lo que contiene Precalculado


    }

    @Override
    public void agregarLista(List<T> listaObjetos) {/*Igual que arriba pero con una lista*/
        getCollectionMongo(repoMongo.getTabla()).insertMany((List<Document>) listaJson);
    }


    @Override
    public void eliminar(T unObjeto) {

    }

    @Deprecated
    @Override
    public List<String> darListaNombres(String unTipo) {
        return null;
    }

    @Deprecated
    @Override
    public T darObjeto(String unNombre, String unTipo) {
        return null;
    }

    @Deprecated
    @Override
    public void modificar(T unObjeto) {}
}
