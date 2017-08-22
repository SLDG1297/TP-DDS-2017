package TestIndicadores;

import java.math.BigDecimal;

import org.junit.Test;

import Modelo.Indicadores.IndicadorBuilder;
import Modelo.Indicadores.Numero;
import Modelo.Indicadores.Suma;
import org.junit.Assert;

public class TestImprimir {
	IndicadorBuilder indicador = new IndicadorBuilder();
	
	@Test
	public void sePuedeImprimirVacio(){
		indicador.setOperandoAnterior(null);
		
		Assert.assertEquals("", indicador.imprimirFormula());
	}
	
	@Test
	public void sePuedeImprimirEDITBAmas(){
		indicador.setOperandoAnterior(new Suma(new Numero(new BigDecimal(2000))));

		Assert.assertEquals("2000 + ", indicador.getOperandoAnterior().imprimirFormula());
	}
}
