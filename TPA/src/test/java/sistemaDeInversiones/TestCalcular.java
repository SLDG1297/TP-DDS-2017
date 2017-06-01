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

	// Para probar Empresas
	Periodo periodo = new Periodo(2001, listaCuentas);
	List<Periodo> periodos = Arrays.asList(periodo);
	
	Empresa empresa = new Empresa("Rolito", periodos);
	
	// Para calcular valores
	Query query = new Query(empresa, periodo);
	
	@Before
	public void iniciarTestCalcular(){
	
	}

	@Test
	public void calculoDeNumeros(){
		Assert.assertEquals(new BigDecimal(200), unaConstante.calcular(query));
	}
	
	@Test
	public void calculoDeCuentas(){
		Assert.assertEquals(new BigDecimal(2000), cuenta1.calcular(query));
	}
}