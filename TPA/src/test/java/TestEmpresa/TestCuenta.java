package TestEmpresa;

import org.junit.After;
import org.junit.Test;
import org.junit.Assert;

import Excepciones.Empresas.CuentaConValorNegativoException;
import Excepciones.Empresas.CuentaSinNombreException;
import Modelo.Empresa.Cuenta;

public class TestCuenta {
	Cuenta prueba1;
	
	@After
	public void resetearCuentas(){
		prueba1 = null;
	}
	
	@Test
	public void sePuedeInstanciarUnaCuenta(){
		prueba1 = UtilsCuenta.crearCuenta("FCF", 10000);
		
		Assert.assertEquals("Se debe poder crear FCF con dicho nombre", prueba1.getNombre(), "FCF");
		Assert.assertEquals("Se debe poder crear FCF con valor 10000", prueba1.getValor(), new Integer(10000));
	}
	
	@Test
	public void sePuedeInstanciarUnaCuentaConValorCero(){
		prueba1 = UtilsCuenta.crearCuenta("FCF", 0);
		
		Assert.assertEquals("El valor de la cuenta es 0", prueba1.getValor(), new Integer(0));
	}
	
	@Test(expected = CuentaSinNombreException.class)
	public void noSeDEberiaInstanciarUnaCuentaSinNombre(){
		prueba1 = UtilsCuenta.crearCuenta("", 20);
	}
	
	@Test(expected = CuentaConValorNegativoException.class)
	public void noSeDeberiaInstanciarUnaCuentaConValorNegativo(){
		prueba1 = UtilsCuenta.crearCuenta("FCF", -1);
	}
}
