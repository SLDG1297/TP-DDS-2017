package DB.Repositorios;

import DB.Excepciones.NoExistenObjetosException;
import DB.TiposDeRepositorios.NombreRepositorio;
import DB.TiposDeRepositorios.RepoDocumental;
import Modelo.Indicadores.Precalculado;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static DB.TiposDeRepositorios.NombreRepositorio.PRECALCULADO;

public class RepositorioPrecalculados extends Repositorio<Precalculado> implements RepoDocumental {

    private static RepositorioPrecalculados instancia = null;

    public static RepositorioPrecalculados getInstancia() {
        if (instancia == null) instancia = new RepositorioPrecalculados(PRECALCULADO);
        return instancia;
    }

    private RepositorioPrecalculados(NombreRepositorio nombreTabla) {
        super(nombreTabla);
    }

    public Object jsonToObjeto(Document doc) {
        double a = doc.getDouble("valor");
        Precalculado p = new Precalculado(doc.getLong("idUsuario"), doc.getLong("idIndicador"),doc.getLong("idEmpresa"),doc.getLong("idPeriodo"), new BigDecimal(a));
        return p;
    }

    @Override
    public String getTabla() {
        return super.getTabla();
    }

    @Override
    public Document crearDocument(Object object) {
        Precalculado precalculado = (Precalculado) object;
        Document doc = new Document("idUsuario",precalculado.getIdUsuario())
                .append("idIndicador",precalculado.getIdIndicador())
                .append("idEmpresa",precalculado.getIdEmpresa())
                .append("idPeriodo",precalculado.getIdPeriodo())
                .append("valor",precalculado.getValor());

        return doc;
    }

}
