package sistemaDeInversiones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDominio {

	private bolsaDeEmpresasParasito bolsaEmpresas = new bolsaDeEmpresasParasito();

	/*@Before
	public void crearBolsaComercialDePrueba() {
		final List<Empresa> listaEmpresas = Arrays.asList(empresa1, empresa2, empresa3);
		bolsaEmpresas.setEmpresas(listaEmpresas);
	}*/

	/*
	
	@Test
	public void SePuedenObtenerNombresDeEmpresas() {
		List<String> nombres = Arrays.asList("Guaymallén","Jorgito","Aguila");
		Assert.assertEquals(bolsaEmpresas.buscarNombresDeEmpresas(), nombres);
	}
	
	*/

	/*@Test
	public void SePuedenObtenerEmpresas() {
		Assert.assertEquals(bolsaEmpresas.buscarEmpresa("Jorgito"), empresa1);
		Assert.assertEquals(bolsaEmpresas.buscarEmpresa("Guaymallén"), empresa2);
		Assert.assertEquals(bolsaEmpresas.buscarEmpresa("Aguila"), empresa3);
	}*/
	
	/*@Test
	public void puedoObtenerInfoDeCuentas(){
		Cuenta cuenta = empresa1.getCuentas().get(0);
	    Assert.assertEquals(cuenta.getNombre(),"EDITBA");
	    Assert.assertEquals(cuenta.getValor(),1000);
	    Assert.assertEquals(cuenta.getPeriodo(),2010);
	}
	*/
	
	/*@Test
	public void puedoTomarElNombreDeLaCuentaDeUnaEmpresa(){
		String nombre = bolsaEmpresas.buscarEmpresa("Jorgito").getCuentas().get(0).getNombre();
		Assert.assertEquals(nombre, "FDS");
	}*/
	
	// PARSEAR UNA EMPRESA SOLA
	
	@Test
	public void parseaUnaEmpresaNombre() {
		List<String> empresa = new ArrayList<String>();
		
		empresa.add("Rolito");
		empresa.add("EDITBA");
		empresa.add("2000");
		empresa.add("6969");
		
		Assert.assertEquals(Parser.aEmpresa(empresa).getNombre(), "Rolito");
	}
	
	@Test
	public void parseaUnaEmpresaTipoDeCuenta() {
		List<String> empresa = new ArrayList<String>();
		
		empresa.add("Rolito");
		empresa.add("EDITBA");
		empresa.add("2000");
		empresa.add("6969");
		
		Assert.assertEquals(Parser.aEmpresa(empresa).getPeriodos().get(0).getCuentas().get(0).getNombre(), "EDITBA");
	}
	
	@Test
	public void parseaUnaEmpresaPeriodo() {
		List<String> empresa = new ArrayList<String>();
		
		empresa.add("Rolito");
		empresa.add("EDITBA");
		empresa.add("2000");
		empresa.add("6969");
		
		Integer anio = 2000;
		
		Assert.assertEquals(Parser.aEmpresa(empresa).getPeriodos().get(0).getAnio(), anio);
	}
	
	@Test
	public void parseaUnaEmpresaValor() {
		List<String> empresa = new ArrayList<String>();
		
		empresa.add("Rolito");
		empresa.add("EDITBA");
		empresa.add("2000");
		empresa.add("6969");
		
		Assert.assertEquals(Parser.aEmpresa(empresa).getPeriodos().get(0).getCuentas().get(0).getValor(), 6969);
	}
	
	// PARSEAR VARIAS EMPRESAS
	
	@Test
	public void parsearVariasEmpresasNombre() {
		List<String> empresa1 = new ArrayList<String>();
		List<String> empresa2 = new ArrayList<String>();
		List<String> empresa3 = new ArrayList<String>();
		List<String> empresa4 = new ArrayList<String>();
		
		empresa1.add("Rolito");
		empresa1.add("EDITBA");
		empresa1.add("2000");
		empresa1.add("6969");
		
		empresa2.add("Rolito");
		empresa2.add("Free Cash Flow");
		empresa2.add("2001");
		empresa2.add("7171");

		empresa3.add("Axel's Consortium Bags");
		empresa3.add("EDITBA");
		empresa3.add("2017");
		empresa3.add("9999");
		
		empresa4.add("Axel's Consortium Bags");
		empresa4.add("Free Cash Flow");
		empresa4.add("2017");
		empresa4.add("1000");
		
		List<List<String>> empresasAParsear = new ArrayList<List<String>>();
		
		empresasAParsear.add(empresa1);
		empresasAParsear.add(empresa2);
		empresasAParsear.add(empresa3);
		empresasAParsear.add(empresa4);
		
		Assert.assertEquals(Parser.aEmpresas(empresasAParsear).get(0).getNombre(), "Rolito");
		Assert.assertEquals(Parser.aEmpresas(empresasAParsear).get(1).getNombre(), "Axel's Consortium Bags");
	}
	
	@Test
	public void parsearVariasEmpresasTiposDeCuenta() {
		List<String> empresa1 = new ArrayList<String>();
		List<String> empresa2 = new ArrayList<String>();
		List<String> empresa3 = new ArrayList<String>();
		List<String> empresa4 = new ArrayList<String>();
		
		empresa1.add("Rolito");
		empresa1.add("EDITBA");
		empresa1.add("2000");
		empresa1.add("6969");
		
		empresa2.add("Rolito");
		empresa2.add("Free Cash Flow");
		empresa2.add("2001");
		empresa2.add("7171");

		empresa3.add("Axel's Consortium Bags");
		empresa3.add("EDITBA");
		empresa3.add("2017");
		empresa3.add("9999");
		
		empresa4.add("Axel's Consortium Bags");
		empresa4.add("Free Cash Flow");
		empresa4.add("2017");
		empresa4.add("1000");
		
		List<List<String>> empresasAParsear = new ArrayList<List<String>>();
		
		empresasAParsear.add(empresa1);
		empresasAParsear.add(empresa2);
		empresasAParsear.add(empresa3);
		empresasAParsear.add(empresa4);
		
		Assert.assertEquals(Parser.aEmpresas(empresasAParsear).get(0).getPeriodos().get(0).getCuentas().get(0).getNombre(), "EDITBA");
		
		
		Assert.assertEquals(Parser.aEmpresas(empresasAParsear).get(0).getPeriodos().get(1).getCuentas().get(0).getNombre(), "Free Cash Flow");
		
		
		Assert.assertEquals(Parser.aEmpresas(empresasAParsear).get(1).getPeriodos().get(0).getCuentas().get(0).getNombre(), "EDITBA");
		
		
		Assert.assertEquals(Parser.aEmpresas(empresasAParsear).get(1).getPeriodos().get(0).getCuentas().get(1).getNombre(), "Free Cash Flow");
	}
	
	@Test
	public void parsearVariasEmpresasPeriodo() {
		List<String> empresa1 = new ArrayList<String>();
		List<String> empresa2 = new ArrayList<String>();
		List<String> empresa3 = new ArrayList<String>();
		List<String> empresa4 = new ArrayList<String>();
		
		empresa1.add("Rolito");
		empresa1.add("EDITBA");
		empresa1.add("2000");
		empresa1.add("6969");
		
		empresa2.add("Rolito");
		empresa2.add("Free Cash Flow");
		empresa2.add("2001");
		empresa2.add("7171");

		empresa3.add("Axel's Consortium Bags");
		empresa3.add("EDITBA");
		empresa3.add("2017");
		empresa3.add("9999");
		
		empresa4.add("Axel's Consortium Bags");
		empresa4.add("Free Cash Flow");
		empresa4.add("2017");
		empresa4.add("1000");
		
		List<List<String>> empresasAParsear = new ArrayList<List<String>>();
		
		empresasAParsear.add(empresa1);
		empresasAParsear.add(empresa2);
		empresasAParsear.add(empresa3);
		empresasAParsear.add(empresa4);
		
		Integer anio = 2000;
		
		Assert.assertEquals(Parser.aEmpresas(empresasAParsear).get(0).getPeriodos().get(0).getAnio(), anio);
		
		anio = 2001;
		
		Assert.assertEquals(Parser.aEmpresas(empresasAParsear).get(0).getPeriodos().get(1).getAnio(), anio);
		
		anio = 2017;
		
		Assert.assertEquals(Parser.aEmpresas(empresasAParsear).get(1).getPeriodos().get(0).getAnio(), anio);
		
		Assert.assertNotEquals(Parser.aEmpresas(empresasAParsear).get(1).getPeriodos().get(1).getAnio(), anio);

	}
	
	@Test
	public void parsearVariasEmpresasValor() {
		List<String> empresa1 = new ArrayList<String>();
		List<String> empresa2 = new ArrayList<String>();
		List<String> empresa3 = new ArrayList<String>();
		List<String> empresa4 = new ArrayList<String>();
		
		empresa1.add("Rolito");
		empresa1.add("EDITBA");
		empresa1.add("2000");
		empresa1.add("6969");
		
		empresa2.add("Rolito");
		empresa2.add("Free Cash Flow");
		empresa2.add("2001");
		empresa2.add("7171");

		empresa3.add("Axel's Consortium Bags");
		empresa3.add("EDITBA");
		empresa3.add("2017");
		empresa3.add("9999");
		
		empresa4.add("Axel's Consortium Bags");
		empresa4.add("Free Cash Flow");
		empresa4.add("2017");
		empresa4.add("1000");
		
		List<List<String>> empresasAParsear = new ArrayList<List<String>>();
		
		empresasAParsear.add(empresa1);
		empresasAParsear.add(empresa2);
		empresasAParsear.add(empresa3);
		empresasAParsear.add(empresa4);
		
		Assert.assertEquals(Parser.aEmpresas(empresasAParsear).get(0).getPeriodos().get(0).getCuentas().get(0).getValor(), 6969);
		
		
		Assert.assertEquals(Parser.aEmpresas(empresasAParsear).get(0).getPeriodos().get(1).getCuentas().get(0).getValor(), 7171);
		
		
		Assert.assertEquals(Parser.aEmpresas(empresasAParsear).get(1).getPeriodos().get(0).getCuentas().get(0).getValor(), 9999);
		
		
		Assert.assertEquals(Parser.aEmpresas(empresasAParsear).get(1).getPeriodos().get(0).getCuentas().get(1).getValor(), 1000);
	}
	
}
