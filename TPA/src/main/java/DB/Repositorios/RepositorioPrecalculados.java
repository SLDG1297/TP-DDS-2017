package DB.Repositorios;

import DB.Excepciones.NoExistenObjetosException;
import DB.TiposDeRepositorios.NombreRepositorio;
import DB.TiposDeRepositorios.RepoDocumental;
import Modelo.Indicadores.Precalculado;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

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

    public Object jsonToObjeto(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Precalculado.class);
    }

    @Override
    public String getTabla() {
        return super.getTabla();
    }

    @Override
    public Document crearDocument(Object object) {
        Precalculado precalculado = (Precalculado) object;
        Document doc = new Document("idUsuario",precalculado.getIdUsuario())
                .append("nombreUsuario",precalculado.getNombreUsuario())
                .append("idIndicador",precalculado.getIdIndicador())
                .append("nombreIndicador",precalculado.getNombreIndicador())
                .append("idEmpresa",precalculado.getIdEmpresa())
                .append("nombreEmpresa",precalculado.getNombreEmpresa())
                .append("idPeriodo",precalculado.getIdPeriodo())
                .append("anioPeriodo",precalculado.getAnioPeriodo())
                .append("valor",precalculado.getValor());

        return doc;
    }

    /*Se puede poner un metodo en el repositorio que sea ejecutar query, que reciba un filter and(eq("x", 1), lt("y", 3))*/

//    public void x (Bson c){
//        collection.find(c);
//    }
    /*uso this.x(Filters.eq("x", 1));*/

    /*DBManager debe tener los metodos persistir, eliminar, buscar, que reciban por parametro el nombre de una coleccion y lo que necesiten/
    las debe usar el proveedor a los metodos, esto permite que se elimine la referencia al repo, y ademas que los repos ya NO tengan la
    necesidad de tener una coleccion dentro, ya que el metodo get da una coleccion y si njo existe la crea
     */

}
