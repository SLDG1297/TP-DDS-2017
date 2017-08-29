package TestIndicadores;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.Theory;

import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.Multiplicacion;
import Modelo.Indicadores.Numero;

public class TestCalcularMultiplicacion extends TemplateTestCalcular {
	Multiplicacion productoExpectante;
	Multiplicacion productoConNatural;
	
	@Before
	public void iniciarMultiplicacion(){
		productoConNatural = new Multiplicacion(natural);
	}
	
	@Test
	public void elProductoDeUnNumeroYSuSimetricoDaElNeutro(){
		productoConNatural.addOperando(new Numero(new BigDecimal(0.05)));
		
		Assert.assertEquals(evaluarEntero(uno), evaluarEntero(productoConNatural));
	}
	
	@Theory
	public void laMultiplicacionEsConmutativa(Expresion operandoIzquierdo, Expresion operandoDerecho){
		int valor1 = evaluarEntero(new Multiplicacion(operandoIzquierdo, operandoDerecho));
		int valor2 = evaluarEntero(new Multiplicacion(operandoDerecho, operandoIzquierdo));
		
		Assert.assertEquals(valor1, valor2);
	}
	
	@Theory
	public void elUnoEsElNeutroDeLaMultiplicacion(Expresion unValor){
		productoExpectante = new Multiplicacion(uno, unValor);
		
		Assert.assertEquals(evaluar(unValor), evaluar(productoExpectante));
	}
	
	@Theory
	public void elCeroEsAbsorbenteEnLaMultiplicacion(Expresion unValor){
		productoExpectante = new Multiplicacion(cero, unValor);
		
		Assert.assertEquals(evaluarEntero(cero), evaluarEntero(productoExpectante));
	}
	
	@Theory
	public void multiplicarPorSignosDistintosDaNegativo(Expresion operandoIzquierdo, Expresion operandoDerecho){
		Assume.assumeTrue(operandoIzquierdo != cero && operandoDerecho != cero);
		Assume.assumeTrue(evaluar(operandoIzquierdo).signum() != evaluar(operandoDerecho).signum());
		
		Assert.assertTrue(evaluar(new Multiplicacion(operandoIzquierdo, operandoDerecho)).signum() == -1);
	}
}
