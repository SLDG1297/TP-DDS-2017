package TestMetodologias.TestComparadores;

import java.util.Arrays;

import org.junit.Before;

import Modelo.Empresa.Cuenta;
import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;
import Modelo.Indicadores.Indicador;

public class TemplateTestComparadores {
	static Cuenta xd2006a, xd2007a, xd2008a, dx2007a, dx2008a, ja2008a;
	static Cuenta xd2007b, xd2008b, dx2008b, ja2008b;
	static Cuenta xd2008c, dx2008c, ja2008c;
	
	static Periodo periodo2006a, periodo2007a, periodo2008a;
	static Periodo periodo2006b, periodo2007b, periodo2008b;
	static Periodo periodo2008c;
	
	static Empresa a, b, c;
	
	static Indicador xxxd, dxxx, jajaja;
	
	@Before
	public void iniciarEmpresaA() {
		xd2006a = new Cuenta("XD", 100);
		xd2007a = new Cuenta("XD", 10);
		xd2008a = new Cuenta("XD", 1000);
		dx2007a = new Cuenta("DX", 500);
		dx2008a = new Cuenta("DX", 1000);
		ja2008a = new Cuenta("JA", 10000);
		
		periodo2006a = new Periodo(2006, Arrays.asList(xd2006a));
		periodo2007a = new Periodo(2007, Arrays.asList(xd2007a, dx2007a));
		periodo2008a = new Periodo(2008, Arrays.asList(xd2008a, dx2008a, ja2008a));
		
		a = new Empresa("A", Arrays.asList(periodo2006a, periodo2007a, periodo2008a));
	}

	@Before
	public void iniciarEmpresaB() {
		xd2007b = new Cuenta("XD", 100);
		xd2008b = new Cuenta("XD", 800);
		dx2008b = new Cuenta("DX", 600);
		ja2008b = new Cuenta("JA", 500);
		
		
	}
}

