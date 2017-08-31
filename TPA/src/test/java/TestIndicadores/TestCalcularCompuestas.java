package TestIndicadores;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.Theory;

import Modelo.Indicadores.*;

public class TestCalcularCompuestas extends TemplateTestCalcular{
	@Test
	public void sePuedeHacerUnCalculoConTodasLasOperacionesYValores(){
		Suma adicion = new Suma(natural, entero);
		
		Multiplicacion producto = new Multiplicacion(adicion, roe);
		
		Parentesis parentesis = new Parentesis(producto);
		
		Resta sustraccion = new Resta(parentesis, ebitda);
		
		Division resultado = new Division(sustraccion, natural);
		
		Assert.assertEquals(new BigDecimal(74780), evaluar(resultado));
	}
	
	@Theory
	public void seCumpleLaPropiedadDistributivaDeLaMultiplicacion(Expresion a, Expresion b){
		Suma sinDistribuir = new Suma(new Multiplicacion(a, b), new Multiplicacion(a, b));
		
		Multiplicacion conDistribucion = new Multiplicacion(a, new Parentesis(new Suma(b, b)));
		
		Assert.assertEquals(evaluar(sinDistribuir), evaluar(conDistribucion));
	}
	
	@Test
	public void elNumeradorPuedeDistribuirseRespectoDeLaSuma(){
		Division sinDistribucion = new Division(new Suma(natural, xd), natural);
		
		Suma conDistribucion = new Suma(new Division(natural, natural), new Division(xd, natural));
		
		Assert.assertEquals(evaluar(sinDistribucion), evaluar(conDistribucion));
	}
}
