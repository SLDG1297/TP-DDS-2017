package TestIndicadores;

import org.junit.Test;

import Modelo.Indicadores.*;
import org.junit.Assert;

public class TestImprimir extends TemplateTestIndicadores {
	public static void impresionParcial(String cadena, Expresion unaExpresion) {
		IndicadorBuilder indicador = new IndicadorBuilder();
		indicador.setOperandoAnterior(unaExpresion);
		
		mostrar(indicador);

		Assert.assertEquals(cadena, indicador.imprimirFormula());
	}
	
	public static void mostrar(IndicadorBuilder unIndicador) {
		System.out.println(unIndicador.imprimirFormula());
	}

	@Test
	public void sePuedeImprimirVacio() {
		Assert.assertEquals("", new IndicadorBuilder().imprimirFormula());
	}

	@Test
	public void sePuedeImprimirSumaParcialConNumeroNatural() {
		impresionParcial("1 + ", new Suma(uno));
	}
	
	@Test
	public void sePuedeImprimirRestaParcialConNumeroEntero() {
		impresionParcial("-500 - ", new Resta(entero));
	}
	
	@Test
	public void sePuedeImprimirProductoParcialConCuenta() {
		impresionParcial("EBITDA * ", new Multiplicacion(ebitda));
	}
	
	@Test
	public void sePuedeImprimirParentesisParcialConIndicador() {
		impresionParcial("( ( ROE = XD - 20 * -500 / EBITDA ) )", new Parentesis(roe));
	}
	
	@Test
	public void sePuedeImprmirExpresionesMezcladas() {
		impresionParcial("1 - 0 + ( -500 * EBITDA / ( ROE = XD - 20 * -500 / EBITDA ) )", new Suma(new Resta(uno, cero), new Parentesis(new Multiplicacion(entero, new Division(ebitda, roe)))));
	}
	
	@Test
	public void sePuedenImprmirMuchosParentesis() {
		impresionParcial("( ( ( ( ROA = ( ROE = XD - 20 * -500 / EBITDA ) + EBITDA ) ) ) )", new Parentesis(new Parentesis(new Parentesis(roa))));
	}
}
