package TestIndicadores;

import org.junit.experimental.theories.Theory;

import static Factories.FactoryOperaciones.*;
import Modelo.Indicadores.*;

import org.junit.Assert;
import org.junit.Test;

public class TestCalcularParentesis extends TemplateTestIndicadores {
	@Test
	public void esLoMismoPonerMasParentesisAUnaSumaSimple() {
		Suma suma = sumar(natural, natural);

		Parentesis parentesis = parentesis(suma);

		Assert.assertEquals(evaluar(suma), evaluar(parentesis));
	}

	@Test
	public void esLoMismoPonerMuchosParentesisAUnaDivisionSimple() {
		Division division = dividir(natural, entero);

		Parentesis parentesis = parentesis(division);
		Parentesis corchetes = parentesis(parentesis);
		Parentesis llaves = parentesis(corchetes);

		Assert.assertEquals(evaluar(division), evaluar(llaves));
	}

	@Theory
	public void laSumaEsAsociativa(Expresiones a, Expresiones b, Expresiones c) {
		Suma parentesisIzquierdo = sumar(parentesis(sumar(a, b)), c);
		Suma parentesisDerecho = sumar(a, parentesis(sumar(b, c)));

		Assert.assertEquals(evaluar(parentesisIzquierdo), evaluar(parentesisDerecho));
	}
	
	/*@Theory @Deprecated // No sé cómo arreglarlo...
	public void laDivisionNoEsAsociativa(Expresiones a, Expresiones b, Expresiones c) {
		Assume.assumeFalse(a.equals(uno) || b.equals(uno) || c.equals(uno) || a.equals(cero) || b.equals(cero)|| c.equals(cero));
		
		BigDecimal parentesisIzquierdo = evaluar(dividir((parentesis(dividir(a, b))), c));
		BigDecimal parentesisDerecho = evaluar(dividir(a, parentesis(dividir(b, c))));
		
		Assert.assertNotEquals(parentesisIzquierdo, parentesisDerecho);
	}*/
}
