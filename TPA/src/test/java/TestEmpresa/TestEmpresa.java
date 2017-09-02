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

import static Factories.FactoryCuenta.*;
import static Factories.FactoryPeriodo.*;
import static Factories.FactoryEmpresa.*;

public class TestEmpresa {
	Cuenta cuenta1, cuenta2, cuenta3, cuenta4, cuenta5, cuenta6;

	Periodo periodo1, periodo2, periodo3, periodo4;

	Empresa empresa;
	
	@Before
	public void iniciarCuentas() {
		cuenta1 = crearCuenta("XD", 680);
		cuenta2 = crearCuenta("DX", 86);
		cuenta3 = crearCuenta("Holis", 1000);
		cuenta4 = crearCuenta("XD", 420);
		cuenta5 = crearCuenta("Aserejé", 15000);
	}
	
	@Before
	public void iniciarPeriodos() {
		periodo1 = crearPeriodo(2006, cuenta1, cuenta2, cuenta4);
		periodo2 = crearPeriodo(2007, cuenta3, cuenta4);
		periodo3 = crearPeriodo(2007, cuenta3);
		periodo4 = crearPeriodo(2008, cuenta5, cuenta3);
	}

	@Before
	public void iniciarEmpresa() {
		empresa = crearEmpresa("Rolito INC.", periodo1, periodo2);
	}

	@Test(expected = EmpresaSinNombreException.class)
	public void noSeDeberianTenerEmpresasSinNombre() {
		crearEmpresa("", periodo1);
	}

	@Test(expected = EmpresaSinPeriodoException.class)
	public void noSeDeberianTenerEmpresasSinPeriodos() {
		crearEmpresa("No hay nada");
	}

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
