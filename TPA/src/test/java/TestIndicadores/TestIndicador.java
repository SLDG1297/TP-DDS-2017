package TestIndicadores;

import org.junit.Test;

import Excepciones.Indicadores.IndicadorSinFormulaException;
import Excepciones.Indicadores.IndicadorSinNombreException;
import Modelo.Indicadores.*;
import org.junit.Assert;

public class TestIndicador extends TemplateTestIndicadores {
	Indicador van = new Indicador("VAN", roe);

	@Test
	public void sePuedeObtenerLaCadenaConLaFormulaDelIndicador() {
		Assert.assertEquals("( VAN = ( ROE = XD - 20 * -500 / EBITDA ) )", van.imprimirFormula());
	}

	@Test(expected = IndicadorSinNombreException.class)
	public void noSePuedeInstanciarIndicadorSinNombre() {
		new Indicador("", cero);
	}

	@Test(expected = IndicadorSinFormulaException.class)
	public void noSePuedeInstanciarIndicadorSinFormula() {
		new Indicador("No Tengo nada", null);
	}
}
