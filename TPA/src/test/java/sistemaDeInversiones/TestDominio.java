package sistemaDeInversiones;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDominio {

	private bolsaDeEmpresas bolsaComercial = new bolsaDeEmpresas();
	private Empresa empresa1 = new Empresa("Random");
	private Empresa empresa2 = new Empresa("Random");
	private Empresa empresa3 = new Empresa("Random");

	@Before
	public void crearBolsaComercialDePrueba() {
		empresa1.setNombre("Jorgito");
		empresa2.setNombre("Guaymallén");
		empresa3.setNombre("Aguila");
		final List<Empresa> listaEmpresas = Arrays.asList(empresa1, empresa2, empresa3);
		bolsaComercial.setEmpresas(listaEmpresas);
	}

	@Test
	public void SePuedenObtenerNombresDeEmpresas() {
		List<String> nombres = Arrays.asList("Jorgito", "Guaymallén", "Aguila");
		Assert.assertEquals(bolsaComercial.buscarNombresDeEmpresas(), nombres);
	}

	@Test
	public void SePuedenObtenerEmpresas() {
		Assert.assertEquals(bolsaComercial.buscarEmpresa("Jorgito"), empresa1);
		Assert.assertEquals(bolsaComercial.buscarEmpresa("Guaymallén"), empresa2);
	}
	
	@Test
	public void puedoObtenerInfoDeCuentas(){
		empresa1.cargarCuentasHardcodeado();
	    Assert.assertEquals(empresa1.getCuentas().get(0).getNombre(),"EDITBA");
	}
	
	/*@Test
	public void susClientesTienenNombre() {
		Assert.assertEquals(bolsaComercial.getEmpresas().get(0).getNombre(), "EDITBA");	
		Assert.assertEquals(bolsaComercial.getEmpresas().get(1).getNombre(), "Free Cash Flow");
	}*/
	
	/*@Test
	public void susClientesTienenValores() {
		Assert.assertEquals(bolsaComercial.getEmpresas().get(0).getValor(), 1000);
		Assert.assertEquals(bolsaComercial.getEmpresas().get(1).getValor(), 2000);
	}
	
	@Test
	public void susClientesTienenPeriodos() {
		Assert.assertEquals(bolsaComercial.getEmpresas().get(0).getPeriodo(), 2010);
		Assert.assertEquals(bolsaComercial.getEmpresas().get(1).getPeriodo(), 1999);
	}*/
	
}
