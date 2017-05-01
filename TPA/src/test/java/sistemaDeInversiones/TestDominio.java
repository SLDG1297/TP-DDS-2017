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
		List<String> nombres = Arrays.asList("Jorgito", "Guaymallén", "Aguila");
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
	public void puedoVerListaDeCuentasDeLaEmpresaSeleccionada(){
		
	}*/
	
	@Test
	public void parseaUnaEmpresa() {
		List<String> empresa = new ArrayList<String>();
		
		empresa.add("Rolito");
		empresa.add("EDITBA");
		empresa.add("2000");
		empresa.add("6969");
		
		Assert.assertEquals(Parser.aEmpresa(empresa).getNombre(), "Rolito");
	}
	
}
