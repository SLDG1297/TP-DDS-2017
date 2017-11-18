package DB.Repositorios;

import DB.Excepciones.NoExistenObjetosException;
import DB.TiposDeRepositorios.NombreRepositorio;
import DB.TiposDeRepositorios.RepoDocumental;
import Modelo.Indicadores.Precalculado;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static DB.TiposDeRepositorios.NombreRepositorio.PRECALCULADO;

public class RepositorioPrecalculados extends Repositorio<Precalculado> implements RepoDocumental {
    private static RepositorioPrecalculados instancia = null;

    private MongoCollection<Document> collection = null;

    private RepositorioPrecalculados(NombreRepositorio nombreTabla) {
        super(nombreTabla);
    }

    public static RepositorioPrecalculados getInstancia() {
        if (instancia == null) instancia = new RepositorioPrecalculados(PRECALCULADO);

        return instancia;
    }

    public Object jsonToObjeto(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Precalculado.class);
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }

    public void setCollection(MongoCollection<Document> collection) {
        this.collection = collection;
    }
}
