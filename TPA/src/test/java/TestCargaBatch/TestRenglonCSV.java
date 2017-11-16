package TestCargaBatch;

import static Factories.FactoryCuenta.crearCuentaConValor;
import static Factories.FactoryEmpresa.crearEmpresa;
import static Factories.FactoryPeriodo.crearPeriodo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Archivo.CargaBatch.RenglonCSV;
import Archivo.CargaBatch.Excepciones.NoSePuedeModificarException;
import Modelo.Empresa.Empresa;

public class TestRenglonCSV {
	Empresa empresa;
	RenglonCSV renglonQueNoPuedeHacerNada, renglonQueAgregaPeriodo, renglonQueAgregaCuenta, renglonQueModificaPosta;
	
	@Before
	public void iniciarRenglones() {
		renglonQueNoPuedeHacerNada = new RenglonCSV("Te la creiste, wey equisde", "EDITBA", "2007", "7171");
		renglonQueAgregaPeriodo = new RenglonCSV("Axel", "EDITBA", "2008", "7171");
		renglonQueAgregaCuenta = new RenglonCSV("Axel", "JajaSalu2", "2007", "7171");
		renglonQueModificaPosta = new RenglonCSV("Axel", "EDITBA", "2007", "7171");
	}
	
	@Before
	public void iniciarEmpresa() {
		empresa =
				crearEmpresa("Axel",
						crearPeriodo(2006,
								crearCuentaConValor("EDITBA", 2),
								crearCuentaConValor("FCF", 3)),
						crearPeriodo(2007,
								crearCuentaConValor("EDITBA", 5),
								crearCuentaConValor("FCF", 10)));
		
	}
	
	@Test
	public void quiereModificarEmpresa() {
		assertTrue(renglonQueAgregaPeriodo.quiereModificarEmpresa(empresa));
	}
	
	@Test
	public void noQuiereModificarEmrpesa() {
		assertFalse(renglonQueNoPuedeHacerNada.quiereModificarCuenta(empresa));
	}
	
	@Test
	public void quiereModificarPeriodo() {
		assertTrue(renglonQueAgregaCuenta.quiereModificarPeriodo(empresa));
	}
	
	@Test
	public void noQuiereModificarPeriodo() {
		assertFalse(renglonQueAgregaPeriodo.quiereModificarPeriodo(empresa));
	}
	
	@Test
	public void parecieraQueQuiereModifciarPeriodoPeroNadaQueVerPorqueLaEmpresaEsDistinta() {
		RenglonCSV renglon = new RenglonCSV("EstaNooo", "EDITBA", "2006", "5470");
		
		assertFalse(renglon.quiereModificarPeriodo(empresa));
	}
	
	@Test
	public void quiereModificarCuenta() {
		assertTrue(renglonQueModificaPosta.quiereModificarCuenta(empresa));
	}
	
	@Test
	public void noQuiereModificarCuenta() {
		assertFalse(renglonQueAgregaCuenta.quiereModificarCuenta(empresa));
	}
	
	@Test
	public void quiereDejarTodoIgual() {
		RenglonCSV renglon = new RenglonCSV("Axel", "EDITBA", "2006", "2");
		
		assertTrue(renglon.quiereModificarCuenta(empresa));
	}
	
	@Test(expected = NoSePuedeModificarException.class)
	public void noDeberiaPoderActualizarseUnaEmpresaConOtroNombre() {
		renglonQueNoPuedeHacerNada.actualizar(empresa);
	}
	
	@Test
	public void permiteAgregarPeriodoNuevo() {
		renglonQueAgregaPeriodo.actualizar(empresa);
		
		assertEquals(renglonQueAgregaPeriodo.getPeriodo(), empresa.buscarPeriodo(renglonQueAgregaPeriodo.getPeriodo().getAnio()));
	}
	
	@Test
	public void permiteAgregarCuentaNueva() {
		renglonQueAgregaCuenta.actualizar(empresa);
		
		assertEquals(renglonQueAgregaCuenta.getCuenta(), empresa.buscarPeriodo(renglonQueAgregaCuenta.getPeriodo().getAnio()).buscarCuenta(renglonQueAgregaCuenta.getCuenta().getNombre()));
	}
	
	@Test
	public void permiteModificarCuenta() {
		renglonQueModificaPosta.actualizar(empresa);
		
		assertEquals(renglonQueModificaPosta.getValor(), empresa.buscarPeriodo(renglonQueModificaPosta.getPeriodo().getAnio()).buscarCuenta(renglonQueModificaPosta.getCuenta().getNombre()).getValor());
	}
}
