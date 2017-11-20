package TestBootstrap;

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
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import DB.MongoDBManager;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;
import com.mongodb.MongoClient;


import java.math.BigDecimal;
import java.net.UnknownHostException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RepoMongo extends MongoDBManager {

    @Before
    public void iniciarRepos(){
        RepositorioUsuarios.getInstancia().setProveedor(new ProveedorBD<Usuario>());

        RepositorioEmpresas.getInstancia().setProveedor(new ProveedorBD<Empresa>());

        RepositorioIndicadores.getInstancia().setProveedor(new ProveedorBD<Indicador>());

        RepositorioMetodologias.getInstancia().setProveedor(new ProveedorBD<Metodologia>());

        RepositorioPrecalculados repo = RepositorioPrecalculados.getInstancia();
        RepositorioPrecalculados.getInstancia().setProveedor(new ProveedorMongoDB<>(repo));
    }

    @Test
    public void a1agregarPrecalculado(){

        Usuario usuario = RepositorioUsuarios.getInstancia().buscarObjeto("axel@bags.com");
        Indicador indicador = RepositorioIndicadores.getInstancia().buscarObjeto("ArrorROE");
        Empresa empresa = RepositorioEmpresas.getInstancia().buscarObjeto("Feel-Fort");
        Periodo periodo = empresa.buscarPeriodo(2006);

        Precalculado p = new Precalculado(usuario.getId(),indicador.getId(),empresa.getId(),periodo.getId(), new BigDecimal(50));

        RepositorioPrecalculados.getInstancia().agregarObjeto(p);
    }

    @Test
    public void a2buscarPrecalculadoconQuery(){
        long a = 1;
        Precalculado p = RepositorioPrecalculados.getInstancia().buscarObjetoPorQuery(Filters.eq("idUsuario", a));

        long u = RepositorioUsuarios.getInstancia().buscarObjeto("axel@bags.com").getId();
        long i = RepositorioIndicadores.getInstancia().buscarObjeto("ArrorROE").getId();
        Empresa empresa = RepositorioEmpresas.getInstancia().buscarObjeto("Feel-Fort");
        long e = empresa.getId();
        long periodo = empresa.buscarPeriodo(2006).getId();

        Precalculado p2 = new Precalculado(u,i,e,periodo,new BigDecimal(50));

        assertEquals(p.getIdUsuario(),p2.getIdUsuario());
        assertEquals(p.getIdIndicador(),p2.getIdIndicador());
        assertEquals(p.getIdEmpresa(), p2.getIdEmpresa());
        assertEquals(p.getIdPeriodo(),p2.getIdPeriodo());
    }

    @Test
    public void a3eliminarPorQuery(){
        long a = 1;
        DeleteResult d = getCollectionMongo("Precalculado").deleteMany(Filters.eq("idUsuario", a));
        assertTrue(d.wasAcknowledged());
    }

}
