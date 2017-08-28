package TestIndicadores;

import org.junit.Test;

import Excepciones.Indicadores.FaltaOperandoDerechoException;
import Modelo.Indicadores.Suma;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;

public class TestCalcularSuma extends TemplateTestCalcular{
	Suma sumaConNatural;
	Suma sumaConEbitda;
	Suma sumaConSumas;
	
	@Before
	public void iniciarSuma(){
		sumaConNatural = new Suma(natural);
		sumaConEbitda = new Suma(natural, ebitda);
		sumaConSumas = new Suma(sumaConEbitda, sumaConEbitda);
	}
	
	@Test
	public void calcularSumaConsigoMismo(){
		sumaConNatural.addOperando(natural);
		
		Assert.assertEquals(40, sumaConNatural.calcular(consulta).intValue());
	}
	
	@Test
	public void calcularSumaConNeutro(){
		sumaConNatural.addOperando(cero);
		
		Assert.assertEquals(natural.calcular(consulta), sumaConNatural.calcular(consulta));
	}
	
	@Test
	public void calcularSumaDeEnteros(){
		sumaConNatural.addOperando(entero);
		
		Assert.assertEquals(-480, sumaConNatural.calcular(consulta).intValue());
	}
	
	@Test
	public void calcularSumaDeReales(){
		sumaConNatural.addOperando(realPositivo);
		
		Assert.assertEquals(new BigDecimal(520.35), sumaConNatural.calcular(consulta));
	}
	
	@Test
	public void calcularSumaNumeroConCuenta(){
		sumaConNatural.addOperando(ebitda);
		
		Assert.assertEquals(new BigDecimal(2020), sumaConNatural.calcular(consulta));
	}
	
	@Test
	public void calcularSumaConOtraSuma(){
		sumaConNatural.addOperando(sumaConEbitda);
		
		Assert.assertEquals(new BigDecimal(2040), sumaConNatural.calcular(consulta));
	}
	
	@Test
	public void calcularSumaConSumaConOtraSuma(){
		Assert.assertEquals(new BigDecimal(4040), sumaConSumas.calcular(consulta));
	}
	
	@Test(expected = FaltaOperandoDerechoException.class)
	public void noSePuedeCalcularSumaSiFaltaElOperandoDerecho(){
		sumaConNatural.calcular(consulta);
	}
}
