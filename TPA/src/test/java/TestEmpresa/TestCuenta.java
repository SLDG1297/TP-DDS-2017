package TestEmpresa;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import Excepciones.Empresas.CuentaConValorNegativoException;
import Excepciones.Empresas.CuentaSinNombreException;
import Modelo.Empresa.Cuenta;

public class TestCuenta {
	Cuenta prueba1;

	@Before
	public void iniciarCuentas() {
		prueba1 = CreadorCuenta.crearCuenta("FCF", 10000);
	}

	@Test
	public void sePuedeInstanciarUnaCuentaConValorCero() {
		prueba1.setValor(0);

		Assert.assertEquals(new Integer(0), prueba1.getValor());
	}

	@Test(expected = CuentaSinNombreException.class)
	public void noSeDEberiaInstanciarUnaCuentaSinNombre() {
		prueba1.setNombre("");
	}

	@Test(expected = CuentaConValorNegativoException.class)
	public void noSeDeberiaInstanciarUnaCuentaConValorNegativo() {
		prueba1.setValor(-1);
	}
}
