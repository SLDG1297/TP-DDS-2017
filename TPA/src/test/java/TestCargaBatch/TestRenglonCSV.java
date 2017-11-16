package TestCargaBatch;

import static Factories.FactoryCuenta.crearCuentaConValor;
import static Factories.FactoryEmpresa.crearEmpresa;
import static Factories.FactoryPeriodo.crearPeriodo;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Archivo.CargaBatch.RenglonCSV;
import Modelo.Empresa.Empresa;

public class TestRenglonCSV {
	Empresa empresa;
	
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
		RenglonCSV renglon = new RenglonCSV("Axel", "EDITBA", "2017", "7171");
		
		assertTrue(renglon.quiereModificarEmpresa(empresa));
	}
	
	@Test
	public void noQuiereModificarEmrpesa() {
		RenglonCSV renglon = new RenglonCSV("Jaj", "Te la creiste", "6578", "8800");
		
		assertFalse(renglon.quiereModificarCuenta(empresa));
	}
	
	@Test
	public void quiereModificarPeriodo() {
		RenglonCSV renglon = new RenglonCSV("Axel", "Ah re", "2006", "8870");
		
		assertTrue(renglon.quiereModificarPeriodo(empresa));
	}
	
	@Test
	public void noQuiereModificarPeriodo() {
		RenglonCSV renglon = new RenglonCSV("Axel", "EDITBA", "2017", "7171");
		
		assertFalse(renglon.quiereModificarPeriodo(empresa));
	}
	
	@Test
	public void parecieraQueQuiereModifciarPeriodoPeroNadaQueVerPorqueLaEmpresaEsDistinta() {
		RenglonCSV renglon = new RenglonCSV("EstaNooo", "EDITBA", "2006", "5470");
		
		assertFalse(renglon.quiereModificarPeriodo(empresa));
	}
	
	@Test
	public void quiereModificarCuenta() {
		RenglonCSV renglon = new RenglonCSV("Axel", "EDITBA", "2006", "8870");
		
		assertTrue(renglon.quiereModificarCuenta(empresa));
	}
}
