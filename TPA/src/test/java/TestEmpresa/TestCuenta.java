package TestEmpresa;

import org.junit.Assert;
import org.junit.Test;

import Excepciones.Empresas.CuentaConValorNegativoException;
import Excepciones.Empresas.CuentaSinNombreException;
import Modelo.Empresa.Cuenta;

import static Factories.FactoryCuenta.*;

public class TestCuenta {
	Cuenta prueba1;

	@Test
	public void sePuedeInstanciarUnaCuentaConValorCero() {
		prueba1 = crearCuentaConValor("FCF", 0);

		Assert.assertEquals(new Integer(0), prueba1.getValor());
	}

	@Test(expected = CuentaSinNombreException.class)
	public void noSeDeberiaInstanciarUnaCuentaSinNombre() {
		prueba1 = crearCuentaConValor("", 0);
	}

	@Test(expected = CuentaConValorNegativoException.class)
	public void noSeDeberiaInstanciarUnaCuentaConValorNegativo() {
		prueba1 = crearCuentaConValor("Esto Esta Mal", -1);
	}
}
