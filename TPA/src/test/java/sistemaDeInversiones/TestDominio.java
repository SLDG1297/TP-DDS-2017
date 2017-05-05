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
	
	@Test
	public void cuentasDeUnaEmpresa(){
	List<Cuenta> listaC1 = Arrays.asList(new Cuenta("EBITDA",2000),new Cuenta("Free Cash Flow",3000),new Cuenta("FDS",4000));
	List<Cuenta> listaC2 = Arrays.asList(new Cuenta("FDS",1000),new Cuenta("EBITDA",1500));
	List<Cuenta> listaC3 = Arrays.asList(new Cuenta("Free Cash Flow",2000));
	List<Periodo> periodo2 = Arrays.asList(new Periodo(2001, listaC2),new Periodo(2014, listaC3),new Periodo(2016, listaC1));
	
	Empresa empresa = new Empresa();
	empresa = bolsaEmpresas.buscarEmpresa("Guaymallén");
	List<Integer> periodosEmpresa = new ArrayList<Integer>();
	periodosEmpresa = empresa.obtenerPeriodos();
	Assert.assertEquals(periodosEmpresa,periodo2);
	
	}
}
