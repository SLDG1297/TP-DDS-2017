package TestCargaBatch;

import org.junit.Before;
import org.junit.Test;

import Archivo.CargaBatch.ReceptorDeEmpresas;
import Archivo.CargaBatch.RenglonCSV;
import DB.Proveedores.ProveedorMock;
import DB.Repositorios.RepositorioEmpresas;
import static Factories.FactoryEmpresa.*;
import static Factories.FactoryPeriodo.*;
import static Factories.FactoryCuenta.*;
import Modelo.Empresa.Empresa;
import static org.junit.Assert.*;

public class TestCarga {
	@Before
	public void iniciarRepositorios(){
		RepositorioEmpresas.getInstancia().setProveedor(new ProveedorMock<Empresa>());
		
		RepositorioEmpresas.getInstancia().agregarObjeto(crearEmpresa("Axel", crearPeriodo(2006, crearCuentaConValor("FCF", 500))));
		RepositorioEmpresas.getInstancia().agregarObjeto(crearEmpresa("Rolito", crearPeriodo(2006, crearCuentaConValor("QEPD", 500))));
	}
	
	@Test
	public void sePuedeIngresarUnaNuevaEmpresa(){
		RenglonCSV renglon = new RenglonCSV("Rip SA", "FCF", "1999", "11500");
		
		ReceptorDeEmpresas.instanciar().insertarEmpresa(renglon);
		
		assertEquals(renglon.getEmpresa().getNombre(), RepositorioEmpresas.getInstancia().buscarObjeto("Rip SA").getNombre());
	}
	
	@Test
	public void noPasaNadaSiIngresoUnaEmpresaExistente(){
		RenglonCSV renglon = new RenglonCSV("Axel", "FCF", "1999", "11500");
		
		ReceptorDeEmpresas.instanciar().insertarEmpresa(renglon);
		
		assertEquals(renglon.getEmpresa().getNombre(), RepositorioEmpresas.getInstancia().buscarObjeto("Axel").getNombre());
	}
}
