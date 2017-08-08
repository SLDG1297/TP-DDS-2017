package TestEmpresa;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Excepciones.Empresas.EmpresaSinNombreException;
import Modelo.Empresa.Cuenta;
import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;

public class TestEmpresa {
	Cuenta cuenta1 = CreadorCuenta.crearCuenta("XD", 680);
	Cuenta cuenta2 = CreadorCuenta.crearCuenta("DX", 86);
	Cuenta cuenta3 = CreadorCuenta.crearCuenta("Holis", 1000);
	Cuenta cuenta4 = CreadorCuenta.crearCuenta("XD", 420);
	Cuenta cuenta5 = CreadorCuenta.crearCuenta("Aserejé", 15000);
	
	Periodo periodo1 = CreadorPeriodo.crearPeriodo(2006, Arrays.asList(cuenta1, cuenta2));
	Periodo periodo2 = CreadorPeriodo.crearPeriodo(2007, Arrays.asList(cuenta3, cuenta4));
	
	Empresa empresa;
	
	@Before
	public void iniciarEmpresa(){
		empresa = CreadorEmpresa.crearEmpresa("Rolito INC.", Arrays.asList(periodo1, periodo2));
	}
	
	@After
	public void resetearEmpresa(){
		empresa = null;
	}
	
	@Test (expected = EmpresaSinNombreException.class)
	public void noSeDeberianTenerEmpresasSinNombre(){
		CreadorEmpresa.crearEmpresa("", Arrays.asList(periodo1));
	}
	
	@Test
	public void unaEmpresaPuedeNoTenerPeriodos(){
		Empresa prueba = CreadorEmpresa.crearEmpresa("No hay nada", null);
		
		Assert.assertEquals(prueba.getPeriodos(), null);
	}
}
