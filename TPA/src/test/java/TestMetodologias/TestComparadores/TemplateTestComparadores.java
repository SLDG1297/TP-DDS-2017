package TestMetodologias.TestComparadores;

import static Factories.FactoryCuenta.crearCuenta;
import static Factories.FactoryEmpresa.crearEmpresa;
import static Factories.FactoryIndicador.crearIndicador;
import static Factories.FactoryNumero.crearNumero;
import static Factories.FactoryOperaciones.*;
import static Factories.FactoryPeriodo.crearPeriodo;

import java.util.Arrays;

import static Factories.FactoryCondiciones.*;
import static Factories.FactoryMetodologia.*;

import org.junit.Before;

import Modelo.Empresa.EmpresasManager;
import Modelo.Empresa.Cuenta;
import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Metodologia;
import Modelo.Metodologias.Condiciones.Condiciones;

public class TemplateTestComparadores {
	static Cuenta xd2006a, xd2007a, xd2008a, dx2007a, dx2008a, ja2008a;
	static Cuenta xd2007b, xd2008b, dx2008b, ja2008b;
	static Cuenta ja2008c;
	
	static Periodo periodo2006a, periodo2007a, periodo2008a;
	static Periodo periodo2006b, periodo2007b, periodo2008b;
	static Periodo periodo2008c;
	
	static Empresa a, b, c;
	
	static EmpresasManager bolsa;
	
	static Indicador xxxd, dxxx, jajaja, estaSiOSi;
	
	static Condiciones mayor, promedio, sumatoria, estaNoLaCumpleNadie, estaLaCumplenTodos, unaSeguraParaTodos, unaImposibleParaTodos, unaTriste;
	
	static Metodologia autosuperacion, imposible, seguro, seguroParaTodos, imposibleParaTodos, muyTriste;
	
	@Before
	public void iniciarTodo() {
		iniciarEmpresaA();
		iniciarEmpresaB();
		iniciarEmpresaC();
		iniciarIndicadores();
		iniciarCondiciones();
		iniciarMetodologias();
		iniciarRepositorio();
	}
	
	public static void iniciarEmpresaA() {
		xd2006a = crearCuenta("XD", 1000);
		xd2007a = crearCuenta("XD", 1500);
		xd2008a = crearCuenta("XD", 2000);
		dx2007a = crearCuenta("DX", 500);
		dx2008a = crearCuenta("DX", 1000);
		ja2008a = crearCuenta("JA", 10000);
		
		periodo2006a = crearPeriodo(2006, xd2006a);
		periodo2007a = crearPeriodo(2007, xd2007a, dx2007a);
		periodo2008a = crearPeriodo(2008, xd2008a, dx2008a, ja2008a);
		
		a = crearEmpresa("A", periodo2006a, periodo2007a, periodo2008a);
	}

	public static void iniciarEmpresaB() {
		xd2007b = crearCuenta("XD", 10);
		xd2008b = crearCuenta("XD", 80);
		dx2008b = crearCuenta("DX", 60);
		ja2008b = crearCuenta("JA", 50);
		
		periodo2007b = crearPeriodo(2007, xd2007b);
		periodo2008b = crearPeriodo(2008, xd2008b, dx2008b, ja2008b);
		
		b = crearEmpresa("B", periodo2007b, periodo2008b);
	}
	
	public static void iniciarEmpresaC() {
		ja2008c = crearCuenta("JA", 2000);
		
		periodo2008c = crearPeriodo(2008, ja2008c);
		
		c = crearEmpresa("C", periodo2008c);
	}
	
	public static void iniciarIndicadores() {
		xxxd = crearIndicador("XXXD", multiplicar(crearNumero(2), xd2006a));
		dxxx = crearIndicador("DXXX", multiplicar(xd2007a, dx2007a));
		jajaja = crearIndicador("JAJAJA", sumar(sumar(xd2008a, dx2008a), ja2008a));
		estaSiOSi = crearIndicador("SiOSi", sumar(crearNumero(1), crearNumero(0)));
	}
	
	public static void iniciarCondiciones() {
		mayor = crearMayorAEnPeriodos(xxxd, 100, 1);
		promedio = crearPromedioMayorA(xxxd, 100);
		sumatoria = crearSumatoriaMayorA(xxxd, 100);
		estaNoLaCumpleNadie = crearMayorAEnPeriodos(xxxd, 10000000, 1);
		estaLaCumplenTodos = crearMayorAEnPeriodos(xxxd, 1, 1);
		unaSeguraParaTodos = crearMayorAEnPeriodos(estaSiOSi, 1, 1);
		unaImposibleParaTodos = crearMayorAEnPeriodos(jajaja, 10000000, 1);
		unaTriste = crearSumatoriaMenorA(dxxx, 2000000);
	}
	
	public static void iniciarMetodologias() {
		autosuperacion = crearMetodologia("Autosuperacion", mayor, promedio, sumatoria);
		imposible = crearMetodologia("Imposible", estaNoLaCumpleNadie);
		seguro = crearMetodologia("Seguro", estaLaCumplenTodos);
		seguroParaTodos = crearMetodologia("Seguro Para Todos", unaSeguraParaTodos);
		imposibleParaTodos = crearMetodologia("Imposible Para Todos", unaImposibleParaTodos);
		muyTriste = crearMetodologia("Tristisimo", unaTriste);
	}

	public static void iniciarRepositorio() {
		bolsa = EmpresasManager.getInstancia();
		bolsa.insertarListaDeEmpresas(Arrays.asList(a, b, c));
	}
	
}

