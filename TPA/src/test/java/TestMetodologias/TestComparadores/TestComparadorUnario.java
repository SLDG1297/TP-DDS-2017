package TestMetodologias.TestComparadores;

import static Modelo.Factories.FactoryComparadores.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestComparadorUnario extends TemplateTestComparadores {
	@Test
	public void empresaACumpleConAutosuperacion() {
		assertTrue(crearComparadorUnario(a, autosuperacion).evaluar());
	}

	@Test
	public void empresaBNoCumpleConAutosuperacion() {
		assertFalse(crearComparadorUnario(b, autosuperacion).evaluar());
	}
	
	@Test
	public void empresaCNoPuedeAutosuperarse() {
		assertFalse(crearComparadorUnario(c, autosuperacion).evaluar());
	}
}
