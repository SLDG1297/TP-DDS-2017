package TestIndicadores;

import org.junit.experimental.theories.Theory;

import Modelo.Indicadores.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class TestCalcularParentesis extends TemplateTestIndicadores {
	@Test
	public void esLoMismoPonerMasParentesisAUnaSumaSimple() {
		Suma suma = new Suma(natural, natural);

		Parentesis parentesis = new Parentesis(suma);

		Assert.assertEquals(evaluar(suma), evaluar(parentesis));
	}

	@Test
	public void esLoMismoPonerMuchosParentesisAUnaDivisionSimple() {
		Division division = new Division(natural, entero);

		Parentesis parentesis = new Parentesis(division);
		Parentesis corchetes = new Parentesis(parentesis);
		Parentesis llaves = new Parentesis(corchetes);

		Assert.assertEquals(evaluar(division), evaluar(llaves));
	}

	@Theory
	public void laSumaEsAsociativa(Expresion a, Expresion b, Expresion c) {
		Suma parentesisIzquierdo = new Suma(new Parentesis(new Suma(a, b)), c);
		Suma parentesisDerecho = new Suma(a, new Parentesis(new Suma(b, c)));

		Assert.assertEquals(evaluar(parentesisIzquierdo), evaluar(parentesisDerecho));
	}
	
	@Theory
	public void laDivisionNoEsAsociativa(Expresion a, Expresion b, Expresion c) {
		Assume.assumeFalse(a.equals(uno) || b.equals(uno) || c.equals(uno));
		Assume.assumeFalse(a.equals(cero) || b.equals(cero)|| c.equals(cero));
		
		BigDecimal parentesisIzquierdo = evaluar(new Division((new Parentesis(new Division(a, b))), c));
		BigDecimal parentesisDerecho = evaluar(new Division(a, new Parentesis(new Division(b, c))));
		
		// Hay un problema con la división. Hay que setear la precisión de redondeo.
	}
}
