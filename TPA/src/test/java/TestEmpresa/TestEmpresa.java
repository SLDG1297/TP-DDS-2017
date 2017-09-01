package TestEmpresa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
	Cuenta cuenta1 = new Cuenta("XD", 680);
	Cuenta cuenta2 = new Cuenta("DX", 86);
	Cuenta cuenta3 = new Cuenta("Holis", 1000);
	Cuenta cuenta4 = new Cuenta("XD", 420);
	Cuenta cuenta5 = new Cuenta("Aserejé", 15000);

	Periodo periodo1 = new Periodo(2006, Arrays.asList(cuenta1, cuenta2, cuenta4));
	Periodo periodo2 = new Periodo(2007, Arrays.asList(cuenta3, cuenta4));
	Periodo periodo3 = new Periodo(2007, Arrays.asList(cuenta3));
	Periodo periodo4 = new Periodo(2008, Arrays.asList(cuenta5, cuenta3));

	Empresa empresa;

	@Before
	public void iniciarEmpresa() {
		List<Periodo> periodos = new LinkedList<Periodo>();
		periodos.addAll(Arrays.asList(periodo1, periodo2));
		
		empresa = new Empresa("Rolito INC.", periodos);
	}

	@Test(expected = EmpresaSinNombreException.class)
	public void noSeDeberianTenerEmpresasSinNombre() {
		new Empresa("", Arrays.asList(periodo1));
	}

	@Test(expected = EmpresaSinPeriodoException.class)
	public void noSeDeberianTenerEmpresasSinPeriodos() {
		new Empresa("No hay nada", Arrays.asList());
	}

	// TODO: No se le puede añadir cuentas y períodos a la empresa. Por qué no son mutables?

	@Test
	public void sePuedenObtenerLosAniosDeLosPeriodos() {
		Assert.assertEquals(Arrays.asList(new Integer(2006), new Integer(2007)), empresa.obtenerAniosDeTodosLosPeriodos());
	}

	@Test
	public void sePuedeEncontrarUnPeriodo() {
		Assert.assertEquals(periodo1, empresa.buscarPeriodo(2006));
	}
	
	@Test
	public void sePuedeEncontrarLaMismaCuentaEnDosPeriodosDistintos() {
		Assert.assertEquals(empresa.buscarPeriodo(2006).buscarCuenta("XD").getNombre(), empresa.buscarPeriodo(2007).buscarCuenta("XD").getNombre());
	}

	@Test(expected = NoExisteElPeriodoException.class)
	public void noSeDeberiaEncontrarUnPeriodoQueNoExiste() {
		empresa.buscarPeriodo(new Integer(-1));
	}

}
