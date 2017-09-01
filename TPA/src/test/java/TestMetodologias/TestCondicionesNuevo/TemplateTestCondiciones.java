package TestMetodologias.TestCondicionesNuevo;

import java.util.Arrays;

import org.junit.Before;

import Modelo.Metodologias.Condiciones.*;

import Modelo.Empresa.Cuenta;
import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.Suma;

public class TemplateTestCondiciones {
	static Cuenta xd2006, xd2007, dx2006, dx2007;

	static Periodo periodo2006, periodo2007;
	
	static Empresa rolito;
	
	static Indicador van;
	
	static CondicionFactory fabrica;

	@Before
	public void iniciarTests() {
		xd2006 = new Cuenta("XD", 680);
		xd2007 = new Cuenta("XD", 420);
		dx2006 = new Cuenta("DX", 86);
		dx2007 = new Cuenta("DX", 500);

		periodo2006 = new Periodo(2006, Arrays.asList(xd2006, dx2006));
		periodo2007 = new Periodo(2007, Arrays.asList(xd2007, dx2007));

		rolito = new Empresa("Rolito INC.", Arrays.asList(periodo2006, periodo2007));
		
		van = new Indicador("VAN", new Suma(xd2006, dx2006));
		
		fabrica = new CondicionFactory();
	}
}
