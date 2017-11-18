package TestCargaBatch;

import org.junit.Before;
import org.junit.Test;

import Archivo.CargaBatch.CompiladorCSV;
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

import java.io.IOException;

public class TestRecepcionDeEmpresas {
	ReceptorDeEmpresas receptor = new ReceptorDeEmpresas();
	RenglonCSV renglonQueNoPuedeHacerNada, renglonQueAgregaPeriodo, renglonQueAgregaCuenta, renglonQueModificaPosta, renglonQueNoHaceNada;
	
	@Before
	public void iniciarRenglones() {
		renglonQueNoPuedeHacerNada = new RenglonCSV("Te la creiste, wey equisde", "EDITBA", 2007, 7171);
		renglonQueAgregaPeriodo = new RenglonCSV("Axel", "EDITBA", 2008, 7171);
		renglonQueAgregaCuenta = new RenglonCSV("Axel", "JajaSalu2", 2007, 7171);
		renglonQueModificaPosta = new RenglonCSV("Axel", "FCF", 2006, 7171);
		renglonQueNoHaceNada = new RenglonCSV("Axel", "FCF", 2006, 500);
	}
	
	@Before
	public void iniciarRepositorios(){
		RepositorioEmpresas.getInstancia().setProveedor(new ProveedorMock<Empresa>());
		
		RepositorioEmpresas.getInstancia().agregarObjeto(crearEmpresa("Axel", crearPeriodo(2006, crearCuentaConValor("FCF", 500))));
		RepositorioEmpresas.getInstancia().agregarObjeto(crearEmpresa("Rolito", crearPeriodo(2006, crearCuentaConValor("QEPD", 500))));
	}

	@Test(expected = NoExisteObjetoConEseNombreException.class)
	public void errorSiSeIntentaModificarObjetoQueNoExiste() {
		receptor.modificarEmpresa(renglonQueNoPuedeHacerNada);
	}
	
	@Test(expected = NoTieneCambiosException.class)
	public void errorSiSeIntentaModificarObjetoQueNoTieneCambios() {
		receptor.modificarEmpresa(renglonQueNoHaceNada);
	}
	
	@Test
	public void sePuedeIngresarUnaNuevaEmpresa() {
		receptor.recibirEmpresa(renglonQueNoPuedeHacerNada);
		
		assertEquals(renglonQueNoPuedeHacerNada.getEmpresa().getNombre(), RepositorioEmpresas.getInstancia().buscarObjeto("Te la creiste, wey equisde").getNombre());
	}
	
	@Test
	public void noPasaNadaSiIngresoUnaEmpresaExistente() {
		receptor.recibirEmpresa(renglonQueModificaPosta);
		
		assertEquals(renglonQueModificaPosta.getEmpresa().getNombre(), RepositorioEmpresas.getInstancia().buscarObjeto("Axel").getNombre());
	}
	
	@Test
	public void sePuedeAgregarUnPeriodoAUnaEmpresa() {
		receptor.recibirEmpresa(renglonQueAgregaPeriodo);
		
		assertEquals(renglonQueAgregaPeriodo.getPeriodo().getAnio(), RepositorioEmpresas.getInstancia().buscarObjeto("Axel").buscarPeriodo(2008).getAnio());
	}
	
	@Test
	public void sePuedeAgregarUnaCuentaAUnaEmpresa() {
		receptor.recibirEmpresa(renglonQueAgregaCuenta);
		
		assertEquals(renglonQueAgregaCuenta.getCuenta().getNombre(), RepositorioEmpresas.getInstancia().buscarObjeto("Axel").buscarPeriodo(2007).buscarCuenta("JajaSalu2").getNombre());
	}
	
	@Test
	public void sePuedeModificarUnaCuentaAUnaEmpresa() {
		receptor.recibirEmpresa(renglonQueModificaPosta);
		
		assertEquals(renglonQueModificaPosta.getValor(), RepositorioEmpresas.getInstancia().buscarObjeto("Axel").buscarPeriodo(2006).buscarCuenta("FCF").getValor());
	}
	
	@Test
	public void noDeberiaOcurrirNadaSiSeQuiereModificarEmpresaSinCambios() {
		Cuenta cuentaAntes = RepositorioEmpresas.getInstancia().buscarObjeto("Axel").buscarPeriodo(2006).buscarCuenta("FCF");
		
		receptor.recibirEmpresa(renglonQueNoHaceNada);
		
		assertEquals(cuentaAntes, RepositorioEmpresas.getInstancia().buscarObjeto("Axel").buscarPeriodo(2006).buscarCuenta("FCF"));
	}
	
	@Test
	public void sePuedeCompilarArchivo() throws IOException {
		CompiladorCSV.instanciar().presentarEmpresas("repositorioEmpresasMock.csv");
	}
}
