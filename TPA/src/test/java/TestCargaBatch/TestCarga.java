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
	RenglonCSV renglonQueNoPuedeHacerNada, renglonQueAgregaPeriodo, renglonQueAgregaCuenta, renglonQueModificaPosta;
	
	@Before
	public void iniciarRenglones() {
		renglonQueNoPuedeHacerNada = new RenglonCSV("Te la creiste, wey equisde", "EDITBA", "2007", "7171");
		renglonQueAgregaPeriodo = new RenglonCSV("Axel", "EDITBA", "2008", "7171");
		renglonQueAgregaCuenta = new RenglonCSV("Axel", "JajaSalu2", "2007", "7171");
		renglonQueModificaPosta = new RenglonCSV("Axel", "EDITBA", "2007", "7171");
	}
	
	@Before
	public void iniciarRepositorios(){
		RepositorioEmpresas.getInstancia().setProveedor(new ProveedorMock<Empresa>());
		
		RepositorioEmpresas.getInstancia().agregarObjeto(crearEmpresa("Axel", crearPeriodo(2006, crearCuentaConValor("FCF", 500))));
		RepositorioEmpresas.getInstancia().agregarObjeto(crearEmpresa("Rolito", crearPeriodo(2006, crearCuentaConValor("QEPD", 500))));
	}
	
	@Test
	public void sePuedeIngresarUnaNuevaEmpresa(){
		ReceptorDeEmpresas.instanciar().recibirEmpresa(renglonQueNoPuedeHacerNada);
		
		assertEquals(renglonQueNoPuedeHacerNada.getEmpresa().getNombre(), RepositorioEmpresas.getInstancia().buscarObjeto("Rip SA").getNombre());
	}
	
	@Test
	public void noPasaNadaSiIngresoUnaEmpresaExistente(){
		ReceptorDeEmpresas.instanciar().recibirEmpresa(renglonQueModificaPosta);
		
		assertEquals(renglonQueModificaPosta.getEmpresa().getNombre(), RepositorioEmpresas.getInstancia().buscarObjeto("Axel").getNombre());
	}
	
	@Test
	public void sePuedeAgregarUnPeriodoAUnaEmpresa(){
		ReceptorDeEmpresas.instanciar().recibirEmpresa(renglonQueAgregaPeriodo);
		
		assertEquals(renglonQueAgregaPeriodo.getPeriodo().getAnio(), RepositorioEmpresas.getInstancia().buscarObjeto("Axel").buscarPeriodo(2008).getAnio());
	}
}
