package TestIndicadores;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import Excepciones.Indicadores.FaltaOperandoDerechoException;
import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.Resta;

@RunWith(Theories.class)
public class TestCalcularResta extends TemplateTestCalcular{
	Resta restaExpectante;
	Resta restaConNatural;
	
	@Before
	public void iniciarResta(){
		restaConNatural = new Resta(natural);
	}
	
	@Theory
	public void restarUnNumeroPorSiMismoDaElNeutro(Expresion unValor){
		restaExpectante = new Resta(unValor, unValor);
		
		Assert.assertTrue(restaExpectante.calcular(consulta).subtract(cero.calcular(consulta)).floatValue() < 1E-10);
	}
	
	@Theory
	public void restarPorNumeroMayorA20DaNegativo(Expresion unValor){
		Assume.assumeTrue(unValor.calcular(consulta).compareTo(natural.calcular(consulta)) == 1);
		
		restaConNatural.addOperando(unValor);
		
		Assert.assertTrue(restaConNatural.calcular(consulta).signum() == -1);
	}
	
	@Theory
	public void noSePuedeRestarSiFaltaElOperandoDerecho(Expresion unValor){
		try
		{
			restaExpectante = new Resta(unValor);
			restaExpectante.calcular(consulta);
		}
		catch (FaltaOperandoDerechoException excepcion)
		{
			Assert.assertEquals(new FaltaOperandoDerechoException(), excepcion);
		}
	}
}
