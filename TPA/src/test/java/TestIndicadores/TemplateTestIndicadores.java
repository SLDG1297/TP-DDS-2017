package TestIndicadores;

import static Factories.FactoryCuenta.crearCuenta;
import static Factories.FactoryEmpresa.crearEmpresa;
import static Factories.FactoryIndicador.crearIndicador;
import static Factories.FactoryNumero.crearNumero;
import static Factories.FactoryOperaciones.*;
import static Factories.FactoryPeriodo.crearPeriodo;
import static Factories.FactoryQueryIndicador.consultar;

import java.math.BigDecimal;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.runner.RunWith;

import Modelo.Empresa.Cuenta;
import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;
import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.Expresiones;
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.Numero;
import Modelo.Indicadores.Query;

@RunWith(Theories.class)
public class TemplateTestIndicadores {
	public static Numero natural = crearNumero(20);
	public static Numero uno = crearNumero(1);
	public static Numero cero = crearNumero(0);
	public static Numero entero = crearNumero(-500);
	public static Numero realPositivo = crearNumero(500.35);
	public static Numero realNegativo = crearNumero(-200.13);

	public static Cuenta ebitda = crearCuenta("EBITDA", 2000);
	public static Cuenta fcf = crearCuenta("FCF", 0);
	public static Cuenta xd = crearCuenta("XD", 12500);
	public static Cuenta otroxd = crearCuenta("XD", 12000);

	public static Indicador roe = crearIndicador("ROE", dividir(multiplicar(restar(xd, natural), entero), ebitda));
	public static Indicador roa = crearIndicador("ROA", sumar(roe, ebitda));

	public static Periodo periodo2001 = crearPeriodo(2001, ebitda, fcf, xd);
	public static Periodo periodo2002 = crearPeriodo(2002, otroxd);

	public static Empresa empresa = crearEmpresa("Rolito", periodo2001, periodo2002);

	public static Query consulta = consultar(empresa, periodo2001);

	@DataPoints
	public static Expresiones[] numerosReales = { natural, uno, cero, entero, realNegativo, realPositivo, ebitda, xd, roe, roa };

	public static BigDecimal evaluar(Expresion unaExpresion) {
		return unaExpresion.calcular(consulta);
	}

	public static int evaluarEntero(Expresion unaExpresion) {
		return evaluar(unaExpresion).intValue();
	}
}
