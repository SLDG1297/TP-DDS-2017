package TestEmpresa;

import java.util.Arrays;
import java.util.Collections;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Excepciones.Empresas.EmpresaSinNombreException;
import Excepciones.Empresas.EmpresaSinPeriodoException;
import Excepciones.Empresas.NoExisteElPeriodoException;
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
	Periodo periodo3 = CreadorPeriodo.crearPeriodo(2007, Arrays.asList(cuenta3));
	Periodo periodo4 = CreadorPeriodo.crearPeriodo(2008, Arrays.asList(cuenta5, cuenta3));

	Empresa empresa;

	@Before
	public void iniciarEmpresa() {
		empresa = CreadorEmpresa.crearEmpresa("Rolito INC.", Arrays.asList(periodo1, periodo2));
	}

	@After
	public void resetearEmpresa() {
		empresa = null;
	}

	@Test(expected = EmpresaSinNombreException.class)
	public void noSeDeberianTenerEmpresasSinNombre() {
		CreadorEmpresa.crearEmpresa("", Arrays.asList(periodo1));
	}

	@Test(expected = EmpresaSinPeriodoException.class)
	public void noSeDeberianTenerEmpresasSinPeriodos() {
		Empresa prueba = CreadorEmpresa.crearEmpresa("No hay nada", null);

		Assert.assertEquals(prueba.getPeriodos(), null);
	}

	// TODO: Tests para añadir cuentas y períodos.

	@Test
	public void sePuedenObtenerLosAniosDeLosPeriodos() {
		Assert.assertEquals(Arrays.asList(new Integer(2006), new Integer(2007)), empresa.obtenerAniosDeTodosLosPeriodos());
	}

	@Test
	public void sePuedeEncontrarUnPeriodo() {
		Assert.assertEquals(periodo1, empresa.buscarPeriodo(2006));
	}

	@Test(expected = NoExisteElPeriodoException.class)
	public void noSeDeberiaEncontrarUnPeriodoQueNoExiste() {
		empresa.buscarPeriodo(new Integer(-1));
	}

}
