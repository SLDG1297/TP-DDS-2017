package TestIndicadores;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import Excepciones.Indicadores.NoSePuedeDividirPorCeroException;
import Modelo.Indicadores.Division;
import Modelo.Indicadores.Numero;

public class TestCalcularDivision extends TemplateTestCalcular {
	Numero dos = new Numero(new BigDecimal(2));
	Numero cuatro = new Numero(new BigDecimal(4));

	Division divisionExpectante;

	@Test(expected = NoSePuedeDividirPorCeroException.class)
	public void noSePuedeDividirPorCero() {
		divisionExpectante = new Division(natural, cero);
	}

	@Test
	public void laDivisionNoEsConmutativa() {
		Division division1 = new Division(natural, entero);
		Division division2 = new Division(entero, natural);

		Assert.assertNotEquals(evaluar(division1), evaluar(division2));
	}

	@Test
	public void dividirDosVecesPorDosEsLoMismoQueDividirPorCuatro() {
		Division divisionPor4 = new Division(natural, cuatro);

		Division divisionPor2 = new Division(new Division(natural, dos), dos);

		Assert.assertEquals(evaluar(divisionPor4), evaluar(divisionPor2));
	}
}
