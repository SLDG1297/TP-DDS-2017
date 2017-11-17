package TestCargaBatch;

import org.junit.Before;
import org.junit.Test;

import Archivo.CargaBatch.ReceptorDeEmpresas;
import Archivo.CargaBatch.RenglonCSV;
import Archivo.CargaBatch.Excepciones.NoTieneCambiosException;
import DB.Excepciones.NoExisteObjetoConEseNombreException;
import DB.Proveedores.ProveedorMock;
import DB.Repositorios.RepositorioEmpresas;
import static Factories.FactoryEmpresa.*;
import static Factories.FactoryPeriodo.*;
import static Factories.FactoryCuenta.*;

import Modelo.Empresa.Cuenta;
import Modelo.Empresa.Empresa;
import static org.junit.Assert.*;

public class TestCarga {
	RenglonCSV renglonQueNoPuedeHacerNada, renglonQueAgregaPeriodo, renglonQueAgregaCuenta, renglonQueModificaPosta, renglonQueNoHaceNada;
	
	@Before
	public void iniciarRenglones() {
		renglonQueNoPuedeHacerNada = new RenglonCSV("Te la creiste, wey equisde", "EDITBA", "2007", "7171");
		renglonQueAgregaPeriodo = new RenglonCSV("Axel", "EDITBA", "2008", "7171");
		renglonQueAgregaCuenta = new RenglonCSV("Axel", "JajaSalu2", "2007", "7171");
		renglonQueModificaPosta = new RenglonCSV("Axel", "FCF", "2006", "7171");
		renglonQueNoHaceNada = new RenglonCSV("Axel", "FCF", "2006", "500");
	}
	
	@Before
	public void iniciarRepositorios(){
		RepositorioEmpresas.getInstancia().setProveedor(new ProveedorMock<Empresa>());
		
		RepositorioEmpresas.getInstancia().agregarObjeto(crearEmpresa("Axel", crearPeriodo(2006, crearCuentaConValor("FCF", 500))));
		RepositorioEmpresas.getInstancia().agregarObjeto(crearEmpresa("Rolito", crearPeriodo(2006, crearCuentaConValor("QEPD", 500))));
	}

	@Test(expected = NoExisteObjetoConEseNombreException.class)
	public void errorSiSeIntentaModificarObjetoQueNoExiste() {
		ReceptorDeEmpresas.instanciar().modificarEmpresa(renglonQueNoPuedeHacerNada);
	}
	
	@Test(expected = NoTieneCambiosException.class)
	public void errorSiSeIntentaModificarObjetoQueNoTieneCambios() {
		ReceptorDeEmpresas.instanciar().modificarEmpresa(renglonQueNoHaceNada);
	}
	
	@Test
	public void sePuedeIngresarUnaNuevaEmpresa() {
		ReceptorDeEmpresas.instanciar().recibirEmpresa(renglonQueNoPuedeHacerNada);
		
		assertEquals(renglonQueNoPuedeHacerNada.getEmpresa().getNombre(), RepositorioEmpresas.getInstancia().buscarObjeto("Te la creiste, wey equisde").getNombre());
	}
	
	@Test
	public void noPasaNadaSiIngresoUnaEmpresaExistente() {
		ReceptorDeEmpresas.instanciar().recibirEmpresa(renglonQueModificaPosta);
		
		assertEquals(renglonQueModificaPosta.getEmpresa().getNombre(), RepositorioEmpresas.getInstancia().buscarObjeto("Axel").getNombre());
	}
	
	@Test
	public void sePuedeAgregarUnPeriodoAUnaEmpresa() {
		ReceptorDeEmpresas.instanciar().recibirEmpresa(renglonQueAgregaPeriodo);
		
		assertEquals(renglonQueAgregaPeriodo.getPeriodo().getAnio(), RepositorioEmpresas.getInstancia().buscarObjeto("Axel").buscarPeriodo(2008).getAnio());
	}
	
	@Test
	public void sePuedeAgregarUnaCuentaAUnaEmpresa() {
		ReceptorDeEmpresas.instanciar().recibirEmpresa(renglonQueAgregaCuenta);
		
		assertEquals(renglonQueAgregaCuenta.getCuenta().getNombre(), RepositorioEmpresas.getInstancia().buscarObjeto("Axel").buscarPeriodo(2007).buscarCuenta("JajaSalu2").getNombre());
	}
	
	@Test
	public void sePuedeModificarUnaCuentaAUnaEmpresa() {
		ReceptorDeEmpresas.instanciar().recibirEmpresa(renglonQueModificaPosta);
		
		assertEquals(renglonQueModificaPosta.getValor(), RepositorioEmpresas.getInstancia().buscarObjeto("Axel").buscarPeriodo(2006).buscarCuenta("FCF").getValor());
	}
	
	@Test
	public void noDeberiaOcurrirNadaSiSeQuiereModificarEmpresaSinCambios() {
		Cuenta cuentaAntes = RepositorioEmpresas.getInstancia().buscarObjeto("Axel").buscarPeriodo(2006).buscarCuenta("FCF");
		
		ReceptorDeEmpresas.instanciar().recibirEmpresa(renglonQueNoHaceNada);
		
		assertEquals(cuentaAntes, RepositorioEmpresas.getInstancia().buscarObjeto("Axel").buscarPeriodo(2006).buscarCuenta("FCF"));
	}
}
