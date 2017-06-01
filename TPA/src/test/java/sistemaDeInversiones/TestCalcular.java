package sistemaDeInversiones;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Modelo.BolsaDeEmpresas;
import Modelo.Expresion;
import Modelo.Operacion;
import Modelo.Numero;
import Modelo.Cuenta;
import Modelo.Indicador;
import Modelo.Suma;
import Modelo.Resta;
import Modelo.Multiplicacion;
import Modelo.Division;
import Modelo.Empresa;
import Modelo.Parentesis;
import Modelo.Periodo;
import Modelo.Query;


public class TestCalcular {
	// Para probar Numeros
	Numero unaConstante = new Numero(new BigDecimal(200));
	
	// Para probar Cuentas
	Cuenta cuenta1 = new Cuenta("EBITDA", 2000);
	Cuenta cuenta2 = new Cuenta("FCF", 3000);
	Cuenta cuenta3 = new Cuenta("XD", 500);
	List<Cuenta> listaCuentas = Arrays.asList(cuenta1, cuenta2, cuenta3);
	
	// Para probar Indicadores
	Indicador indicador;

	// Para probar Empresas
	Periodo periodo = new Periodo(2001, listaCuentas);
	List<Periodo> periodos = Arrays.asList(periodo);
	Empresa empresa = new Empresa("Rolito", periodos);
	
	// Para calcular valores
	Query query = new Query(empresa, periodo);
	
	@Before
	public void iniciarTestCalcular(){
		// Indicador: PIB = ((FCF - EBITDA) * XD)/200
		Resta sustraccion = new Resta(cuenta2);
		sustraccion.addOperando(cuenta1);
		
		Multiplicacion producto = new Multiplicacion(sustraccion);
		producto.addOperando(cuenta3);
		
		Division formula = new Division(producto);
		formula.addOperando(unaConstante);
		
		indicador = new Indicador("PIB", formula);
	}

	@Test
	public void calculoDeNumeros(){
		Assert.assertEquals(new BigDecimal(200), unaConstante.calcular(query));
	}
	
	@Test
	public void calculoDeCuentas(){
		Assert.assertEquals(new BigDecimal(2000), cuenta1.calcular(query));
	}
	
	@Test
	public void calculoDeSuma(){
		// Fórmula: 200 + FCF
		Suma suma = new Suma(unaConstante);
		suma.addOperando(cuenta2);
		
		Assert.assertEquals(new BigDecimal(3200), suma.calcular(query));
	}
	
	@Test
	public void calculoResta(){
		// Fórmula: FCF - EBITDA
		Resta sustraccion = new Resta(cuenta2);
		sustraccion.addOperando(cuenta1);
		
		Assert.assertEquals(new BigDecimal(1000), sustraccion.calcular(query));
	}
	
	@Test
	public void calculoProducto(){
		// Fórmula: EBITDA * XD
		Multiplicacion producto = new Multiplicacion(cuenta1);
		producto.addOperando(cuenta3);
		
		Assert.assertEquals(new BigDecimal(1000000), producto.calcular(query));
	}
	
	@Test
	public void calculoDivision(){
		// Fórmula: EBITDA / XD
		Division cociente = new Division(cuenta1);
		cociente.addOperando(cuenta3);
		
		Assert.assertEquals(new BigDecimal(4), cociente.calcular(query));
	}
	
	@Test
	public void calculoOperacionesAnidadas(){
		Assert.assertEquals(new BigDecimal(2500), indicador.calcular(query));
	}
	
	@Test
	public void calculoConIndicador(){
		// Fórmula: EBITDA + PIB
		Suma suma = new Suma(cuenta1);
		suma.addOperando(indicador);
		
		Assert.assertEquals(new BigDecimal(4500), suma.calcular(query));
	}
}