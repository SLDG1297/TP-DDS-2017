package TestIndicadores;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.Theory;

import Excepciones.Indicadores.FaltaOperandoDerechoException;
import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.Resta;

public class TestCalcularResta extends TemplateTestCalcular{
	Resta restaExpectante;
	Resta restaConNatural;
	
	@Before
	public void iniciarResta(){
		restaConNatural = new Resta(natural);
	}
	
	@Test
	public void sePuedenRestarVariosOperandos(){
		restaConNatural.addOperando(new Resta(cero, uno));
		
		Assert.assertEquals(new BigDecimal(21), evaluar(restaConNatural));
	}
	
	@Theory
	public void restarPorCeroDaSiMismo(Expresion unValor){
		restaExpectante = new Resta(unValor, cero);
		
		Assert.assertEquals(evaluar(unValor), evaluar(restaExpectante));
	}
	
	@Theory
	public void restarUnNumeroPorSiMismoDaElNeutro(Expresion unValor){
		restaExpectante = new Resta(unValor, unValor);
		
		Assert.assertTrue(evaluarEntero(restaExpectante) == evaluarEntero(cero));
	}
	
	@Theory
	public void restarPorNumeroMayorA20DaNegativo(Expresion unValor){
		Assume.assumeTrue(evaluar(unValor).compareTo(evaluar(natural)) == 1);
		
		restaConNatural.addOperando(unValor);
		
		Assert.assertTrue(evaluar(restaConNatural).signum() == -1);
	}
	
	@Theory
	public void laRestaNoEsConmutativaPorElOrdenEnQueSeAniadenOperandos(Expresion operandoIzquierdo, Expresion operandoDerecho){
		Assume.assumeFalse(operandoIzquierdo.equals(operandoDerecho));
		
		int valor1 = evaluarEntero(new Resta(operandoIzquierdo, operandoDerecho));
		int valor2 = evaluarEntero(new Resta(operandoDerecho, operandoIzquierdo));
		
		Assert.assertNotEquals(valor1, valor2);
	}
	
	@Theory
	public void noSePuedeRestarSiFaltaElOperandoDerecho(Expresion unValor){
		try
		{
			restaExpectante = new Resta(unValor);
			evaluar(restaExpectante);
		}
		catch (FaltaOperandoDerechoException excepcion)
		{
			Assert.assertEquals(new FaltaOperandoDerechoException(), excepcion);
		}
	}
}
