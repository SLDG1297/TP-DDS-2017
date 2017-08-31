package TestIndicadores;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import Modelo.Empresa.Cuenta;
import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;
import Modelo.Indicadores.*;

@RunWith(Theories.class)
public class TemplateTestIndicadores {
	public static Numero natural = new Numero(new BigDecimal(20));
	public static Numero uno = new Numero(new BigDecimal(1));
	public static Numero cero = new Numero(new BigDecimal(0));
	public static Numero entero = new Numero(new BigDecimal(-500));
	public static Numero realPositivo = new Numero(new BigDecimal(500.35));
	public static Numero realNegativo = new Numero(new BigDecimal(-200.13));
	
	public static Cuenta ebitda = new Cuenta("EBITDA", 2000);
	public static Cuenta fcf = new Cuenta("FCF", 0);
	public static Cuenta xd = new Cuenta("XD", 12500);
	
	public static Indicador roe = crearMockDeIndicador();
	public static Indicador roa = new Indicador("ROA", new Suma(roe, ebitda));
	
	public static Periodo periodo;
	
	public static Empresa empresa;
	
	public static Query consulta;
	
	@DataPoints
	public static Expresion[] numerosReales = {natural, uno, cero, entero, realNegativo, realPositivo, ebitda, xd, roe, roa};
	
	public static BigDecimal evaluar(Expresion unaExpresion){
		return unaExpresion.calcular(consulta);
	}
	
	public static int evaluarEntero(Expresion unaExpresion){
		return evaluar(unaExpresion).intValue();
	}
	
	public static Indicador crearMockDeIndicador(){
		Resta sustraccion = new Resta(xd);
		sustraccion.addOperando(natural);
		
		Multiplicacion producto = new Multiplicacion(sustraccion);
		producto.addOperando(entero);
		
		Division formula = new Division(producto);
		formula.addOperando(ebitda);
		
		return new Indicador("ROE", formula);
	}
	
	@Before
	public void iniciarExpresiones(){
		periodo = new Periodo(2001, Arrays.asList(ebitda, fcf, xd));
		
		empresa = new Empresa("Rolito", Arrays.asList(periodo));
		
		consulta = new Query(empresa, periodo.getAnio());
	}
}
