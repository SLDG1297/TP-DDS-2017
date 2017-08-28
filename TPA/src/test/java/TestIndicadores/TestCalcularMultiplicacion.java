package TestIndicadores;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.Multiplicacion;

@RunWith(Theories.class)
public class TestCalcularMultiplicacion extends TemplateTestCalcular {
	Multiplicacion productoExpectante;
	Multiplicacion productoConNatural;
	
	@Before
	public void iniciarMultiplicacion(){
		productoConNatural = new Multiplicacion(natural);
	}
	
	@Theory
	public void multiplicarPorSignosDistintosDaNegativo(Expresion operandoIzquierdo, Expresion operandoDerecho){
		Assume.assumeTrue(operandoIzquierdo != cero && operandoDerecho != cero);
		Assume.assumeTrue(operandoIzquierdo.calcular(consulta).signum() != operandoDerecho.calcular(consulta).signum());
		
		Assert.assertTrue(new Multiplicacion(operandoIzquierdo, operandoDerecho).calcular(consulta).signum() == -1);
	}
}
