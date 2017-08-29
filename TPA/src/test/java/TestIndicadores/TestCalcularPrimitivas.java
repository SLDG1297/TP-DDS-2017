package TestIndicadores;

import org.junit.Assert;
import org.junit.Test;

public class TestCalcularPrimitivas extends TemplateTestCalcular{
	@Test
	public void sePuedeCalcularUnNumero() {
		Assert.assertEquals(20, evaluarEntero(natural));
	}

	@Test
	public void sePuedeCalcularUnaCuenta() {
		Assert.assertEquals(2000, evaluarEntero(ebitda));
	}
}
