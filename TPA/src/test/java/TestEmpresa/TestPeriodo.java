package TestEmpresa;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Excepciones.Empresas.PeriodoSinCuentasException;
import Excepciones.Empresas.YaExisteLaCuentaException;
import Excepciones.Indicadores.NoTieneLaCuentaException;
import Modelo.Empresa.Cuenta;
import Modelo.Empresa.Periodo;

import static Factories.FactoryCuenta.*;
import static Factories.FactoryPeriodo.*;

public class TestPeriodo {
	Cuenta cuenta1, cuenta2, cuenta3;

	Periodo periodo;

	@Before
	public void iniciarCuentas() {
		cuenta1 = crearCuenta("Rolito", 500);
		cuenta2 = crearCuenta("Axxxel", 700);
		cuenta3 = crearCuenta("Skybell", 800);
	}

	@Before
	public void iniciarPeriodo() {
		periodo = crearPeriodo(2000, cuenta1, cuenta2);
	}

	@Test(expected = PeriodoSinCuentasException.class)
	public void noSeDeberiaPoderCrearUnPeriodoSinCuentas() {
		crearPeriodo(2000);
	}
	
	@Test
	public void sePuedeBuscarUnaCuenta() {
		Cuenta cuentaBuscada = periodo.buscarCuenta("Rolito");

		Assert.assertEquals(cuenta1, cuentaBuscada);
	}

	@Test
	public void sePuedenEncontrarTodasLasCuentas() {
		Cuenta rolito = periodo.buscarCuenta("Rolito");
		Cuenta axxxel = periodo.buscarCuenta("Axxxel");

		Assert.assertEquals(cuenta1, rolito);
		Assert.assertEquals(cuenta2, axxxel);
	}

	@Test(expected = NoTieneLaCuentaException.class)
	public void noDeberiaEncontrarseUnaCuentaQueNoEstaEnElPeriodo() {
		periodo.buscarCuenta("PuseCualquierCosa");
	}

	@Test
	public void sePuedeAgregarUnaCuenta() {
		periodo.agregarCuenta(cuenta3);

		Assert.assertEquals(Arrays.asList(cuenta1, cuenta2, cuenta3), periodo.getCuentas());
	}

	@Test(expected = YaExisteLaCuentaException.class)
	public void noSeDeberiaAgregarUnaCuentaQueYaExsite() {
		periodo.agregarCuenta(cuenta1);
	}

	// No entiendo el método 'Está Entre', de hecho, no trabaja con el estado
	// interno de un Período, así que
	// no está bien que es responsabilidad esté ahí.
}
