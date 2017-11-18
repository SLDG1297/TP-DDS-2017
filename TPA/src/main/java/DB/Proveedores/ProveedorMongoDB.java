package DB.Proveedores;

import DB.MongoDBManager;
import DB.TiposDeRepositorios.TipoDeRepositorio;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.List;

public class ProveedorMongoDB<T extends TipoDeRepositorio> extends MongoDBManager implements Proveedor<T> {

    public ProveedorMongoDB() {super();}

    private MongoCollection<Document> collection = null;

    @Override
    public T darObjeto(String unNombre, String unTipo) {
        if(collection == null)
        {
            collection = crearColeccion(unTipo);
        }

        return null;
    }

    @Override
    public List<T> darLista(String unTipo) {
        if(collection == null)
        {
            collection = crearColeccion(unTipo);
        }
        return null;
    }

    @Override
    public List<String> darListaNombres(String unTipo) {
        if(collection == null)
        {
            collection = crearColeccion(unTipo);
        }
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
