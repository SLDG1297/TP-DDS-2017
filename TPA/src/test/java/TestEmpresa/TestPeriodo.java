package TestEmpresa;

import java.util.Arrays;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Excepciones.Empresas.PeriodoAnioNoPositivoException;
import Excepciones.Empresas.PeriodoSinCuentasException;
import Excepciones.Empresas.YaExisteLaCuentaException;
import Excepciones.Indicadores.NoTieneLaCuentaException;
import Modelo.Empresa.Cuenta;
import Modelo.Empresa.Periodo;

public class TestPeriodo {
	Cuenta cuenta1 = UtilsCuenta.crearCuenta("Rolito", 500);
	Cuenta cuenta2 = UtilsCuenta.crearCuenta("Axxxel", 700);
	Cuenta cuenta3 = UtilsCuenta.crearCuenta("Skybell", 800);
	Periodo periodo;
	
	@Before
	public void iniciarPeriodo(){
		periodo = UtilsPeriodo.crearPeriodo(2000, Arrays.asList(cuenta1, cuenta2));
	}
	
	@After
	public void resetarPeriodo(){
		periodo = null;
	}
	
	@Test(expected = PeriodoAnioNoPositivoException.class)
	public void noSeDeberiaPoderCrearUnPeriodoDelAñoCero(){
		periodo.setAnio(0);
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
		// No funciona porque Arrays.asList en Período no devuelve una lista que pueda redimensionarse.
		// Más info acá: https://stackoverflow.com/questions/9320409/unsupportedoperationexception-at-java-util-abstractlist-add
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
	
	// No entiendo el método 'Está Entre'
}
