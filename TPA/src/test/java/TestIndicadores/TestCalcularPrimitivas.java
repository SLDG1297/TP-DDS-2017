package TestIndicadores;

import org.junit.Assert;
import org.junit.Test;

public class TestCalcularPrimitivas extends TemplateTestCalcular{
	@Test
	public void sePuedeCalcularUnNumero() {
		Assert.assertEquals(20, natural.calcular(consulta).intValue());
	}

	@Test
	public void sePuedeCalcularUnaCuenta() {
		Assert.assertEquals(2000, ebitda.calcular(consulta).intValue());
	}
}
