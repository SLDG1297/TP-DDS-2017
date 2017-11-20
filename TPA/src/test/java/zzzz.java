import DB.Proveedores.ProveedorBD;
import DB.Proveedores.ProveedorMongoDB;
import DB.Repositorios.*;
import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.Precalculado;
import Modelo.Metodologias.Metodologia;
import Modelo.Usuarios.Usuario;
import com.mongodb.*;
import org.junit.Test;



import java.net.UnknownHostException;

public class zzzz {

    @Test
    public void agregarPrecalculado(){

        RepositorioUsuarios.getInstancia().setProveedor(new ProveedorBD<Usuario>());

        RepositorioEmpresas.getInstancia().setProveedor(new ProveedorBD<Empresa>());

        RepositorioIndicadores.getInstancia().setProveedor(new ProveedorBD<Indicador>());

        RepositorioMetodologias.getInstancia().setProveedor(new ProveedorBD<Metodologia>());

        RepositorioPrecalculados repo = RepositorioPrecalculados.getInstancia();
        RepositorioPrecalculados.getInstancia().setProveedor(new ProveedorMongoDB<>(repo));



        Usuario usuario = RepositorioUsuarios.getInstancia().buscarObjeto("axel@bags.com");
        Indicador indicador = RepositorioIndicadores.getInstancia().buscarObjeto("ArrorROE");
        Empresa empresa = RepositorioEmpresas.getInstancia().buscarObjeto("Feel-Fort");
        Periodo periodo = empresa.buscarPeriodo(2006);

        Precalculado p = new Precalculado(usuario,indicador,empresa,periodo);

        RepositorioPrecalculados.getInstancia().agregarObjeto(p);
    }

    @Test
    public void t(){
        DB db=null;
        DBCollection table=null;

        MongoClient mongoClient = new MongoClient();

        //insert data
        db = (DB) mongoClient.getDatabase("testdb");
        table = db.getCollection("testcoll");

        //create document and insert
        BasicDBObject document = new BasicDBObject();
        document.put("name", "Andre");
        document.put("age", 34);

        BasicDBObject document2 = new BasicDBObject();
        document2.put("name", "Beatrix");
        document2.put("age", 19);

        table.insert(document);
        table.insert(document2);

    }
}
