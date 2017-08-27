package TestEmpresa;

import org.junit.Test;
import org.junit.Assert;

import Excepciones.Empresas.CuentaConValorNegativoException;
import Excepciones.Empresas.CuentaSinNombreException;
import Modelo.Empresa.Cuenta;

public class TestCuenta {
	Cuenta prueba1;

	@Test
	public void sePuedeInstanciarUnaCuentaConValorCero() {
		prueba1 = new Cuenta("FCF", 0);

		Assert.assertEquals(new Integer(0), prueba1.getValor());
	}

	@Test(expected = CuentaSinNombreException.class)
	public void noSeDeberiaInstanciarUnaCuentaSinNombre() {
		prueba1 = new Cuenta("", 0);
	}

	@Test(expected = CuentaConValorNegativoException.class)
	public void noSeDeberiaInstanciarUnaCuentaConValorNegativo() {
		prueba1 = new Cuenta("Esto Esta Mal", 0);
	}
}
