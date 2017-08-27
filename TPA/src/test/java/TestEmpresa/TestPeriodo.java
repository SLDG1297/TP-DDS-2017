package TestEmpresa;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Excepciones.Empresas.PeriodoSinCuentasException;
import Excepciones.Empresas.YaExisteLaCuentaException;
import Excepciones.Indicadores.NoTieneLaCuentaException;
import Modelo.Empresa.Cuenta;
import Modelo.Empresa.Periodo;

public class TestPeriodo {
	Cuenta cuenta1 = new Cuenta("Rolito", 500);
	Cuenta cuenta2 = new Cuenta("Axxxel", 700);
	Cuenta cuenta3 = new Cuenta("Skybell", 800);
	
	Periodo periodo;
	
	@Before
	public void iniciarPeriodo(){
		List<Cuenta> cuentas = new LinkedList<Cuenta>();
		cuentas.addAll(Arrays.asList(cuenta1, cuenta2));
		
		periodo = new Periodo(2000, cuentas);
	}
	
	@Test(expected = PeriodoSinCuentasException.class)
	public void noSeDeberiaPoderCrearUnPeriodoSinCuentas(){
		periodo.setCuentas(null);
	}
	
	@Test
	public void sePuedenEncontrarTodasLasCuentas(){
		Cuenta rolito = periodo.buscarCuenta("Rolito");
		Cuenta axxxel = periodo.buscarCuenta("Axxxel");
		
		Assert.assertEquals(cuenta1, rolito);
		Assert.assertEquals(cuenta2, axxxel);
	}
	
	@Test(expected = NoTieneLaCuentaException.class)
	public void noDeberiaEncontrarseUnaCuentaQueNoEstaEnElPeriodo(){
		periodo.buscarCuenta("PuseCualquierCosa");
	}
	
	@Test
	public void sePuedeAgregarUnaCuenta(){
		periodo.agregarCuenta(cuenta3);
		
		Assert.assertEquals(Arrays.asList(cuenta1, cuenta2, cuenta3), periodo.getCuentas());
	}
	
	@Test(expected = YaExisteLaCuentaException.class)
	public void noSeDeberiaAgregarUnaCuentaQueYaExsite(){
		periodo.agregarCuenta(cuenta1);
	}
	
	@Test
	public void sePuedeBuscarUnaCuenta(){
		Cuenta cuentaBuscada = periodo.buscarCuenta("Rolito");
		
		Assert.assertEquals(cuenta1, cuentaBuscada);
	}
	
	@Test (expected = NoTieneLaCuentaException.class)
	public void noSeDeberiaEncontrarUnaCuentaQueNoExiste(){
		periodo.buscarCuenta("NoDeberíaHaberUnaEmpresaAsí");
	}

	// No entiendo el método 'Está Entre', de hecho, no trabaja con el estado
	// interno de un Período, así que
	// no está bien que es responsabilidad esté ahí.
}
