package DB.Proveedores;

import DB.MongoDBManager;
import DB.Repositorios.Repositorio;
import DB.TiposDeRepositorios.RepoDocumental;
import DB.TiposDeRepositorios.TipoDeRepositorio;
import Modelo.Indicadores.Precalculado;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import com.mongodb.client.MongoCursor;

import java.util.ArrayList;
import java.util.List;

public class ProveedorMongoDB<T extends TipoDeRepositorio> extends MongoDBManager implements Proveedor<T> {

    private RepoDocumental repoMongo;

    public ProveedorMongoDB(RepoDocumental repoMongo) {
        this.repoMongo = repoMongo;
    }

    private void comprobarCollection(String unTipo) {
        if (repoMongo.getCollection() == null) {
            repoMongo.setCollection(this.crearColeccionMongo(unTipo));
        }
    }

    @Override
    public T darObjeto(String unNombre, String unTipo) {
        return null;
    }

    @Override
    public List<T> darLista(String unTipo) {
        this.comprobarCollection(unTipo);
        List<T> lista = new ArrayList<>();
        MongoCursor<Document> cursor = repoMongo.getCollection().find().iterator();
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
    public List<String> darListaNombres(String unTipo) {
        return null;
    }

    @Override
    public void agregar(T unObjeto) {/*Se sobreescribe, se recibe un Obj Precalculado, y aca dentro se crea un Obj Document y este Document se pasar por parametro al super*/
        //Aca Descomponer Obj Precalculado, crear document, y llenarlo con lo que contiene Precalculado
        repoMongo.getCollection().insertOne(json);
    }

    @Override
    public void agregarLista(List<T> listaObjetos) {/*Igual que arriba pero con una lista*/
        repoMongo.getCollection().insertMany((List<Document>) listaJson);
    }

    @Override
    public void modificar(T unObjeto) {

    }

    @Override
    public void eliminar(T unObjeto) {

    }
}
