package TestIndicadores;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Before;
import org.junit.experimental.theories.DataPoints;

import Modelo.Empresa.Cuenta;
import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;
import Modelo.Indicadores.*;

public class TemplateTestCalcular {
	public static Numero natural = new Numero(new BigDecimal(20));
	public static Numero uno = new Numero(new BigDecimal(1));
	public static Numero cero = new Numero(new BigDecimal(0));
	public static Numero entero = new Numero(new BigDecimal(-500));
	public static Numero realPositivo = new Numero(new BigDecimal(500.35));
	public static Numero realNegativo = new Numero(new BigDecimal(-200.13));
	
	public static Cuenta ebitda = new Cuenta("EBITDA", 2000);
	public static Cuenta fcf = new Cuenta("FCF", 0);
	
	public static Periodo periodo;
	
	public static Empresa empresa;
	
	public static Query consulta;
	
	@DataPoints
	public static Expresion[] numerosReales = {natural, uno, cero, entero, realNegativo, realPositivo, ebitda};
	
	@Before
	public void iniciarExpresiones(){
		periodo = new Periodo(2001, Arrays.asList(ebitda, fcf));
		
		empresa = new Empresa("Rolito", Arrays.asList(periodo));
		
		consulta = new Query(empresa, periodo.getAnio());
	}
}
