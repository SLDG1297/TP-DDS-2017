package TestIndicadores;

import java.math.BigDecimal;

import static Factories.FactoryOperaciones.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.Theory;

import Modelo.Indicadores.*;

public class TestCalcularCompuestas extends TemplateTestIndicadores{
	@Test
	public void sePuedeHacerUnCalculoConTodasLasOperacionesYValores(){
		Suma adicion = sumar(natural, entero);
		
		Multiplicacion producto = multiplicar(adicion, roe);
		
		Parentesis parentesis = parentesis(producto);
		
		Resta sustraccion = restar(parentesis, ebitda);
		
		Division resultado = dividir(sustraccion, natural);
		
		Assert.assertEquals(new BigDecimal(74780), evaluar(resultado));
	}
	
	@Theory
	public void seCumpleLaPropiedadDistributivaDeLaMultiplicacion(Expresion a, Expresion b){
		Suma sinDistribuir = sumar(multiplicar(a, b), multiplicar(a, b));
		
		Multiplicacion conDistribucion = multiplicar(a, parentesis(sumar(b, b)));
		
		Assert.assertEquals(evaluar(sinDistribuir), evaluar(conDistribucion));
	}
	
	@Test
	public void elNumeradorPuedeDistribuirseRespectoDeLaSuma(){
		Division sinDistribucion = dividir(sumar(natural, xd), natural);
		
		Suma conDistribucion = sumar(dividir(natural, natural), dividir(xd, natural));
		
		Assert.assertEquals(evaluar(sinDistribucion), evaluar(conDistribucion));
	}
}
