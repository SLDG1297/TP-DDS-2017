package sistemaDeInversiones;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDominio {

	private bolsaDeEmpresas bolsaEmpresas = new bolsaDeEmpresas();
	private Empresa empresa1 = new Empresa("Jorgito");
	private Empresa empresa2 = new Empresa("Guaymall�n");
	private Empresa empresa3 = new Empresa("Aguila");

	@Before
	public void crearBolsaComercialDePrueba() {
		final List<Empresa> listaEmpresas = Arrays.asList(empresa1, empresa2, empresa3);
		bolsaEmpresas.setEmpresas(listaEmpresas);
	}

	@Test
	public void SePuedenObtenerNombresDeEmpresas() {
		List<String> nombres = Arrays.asList("Jorgito", "Guaymall�n", "Aguila");
		Assert.assertEquals(bolsaEmpresas.buscarNombresDeEmpresas(), nombres);
	}

	@Test
	public void SePuedenObtenerEmpresas() {
		Assert.assertEquals(bolsaEmpresas.buscarEmpresa("Jorgito"), empresa1);
		Assert.assertEquals(bolsaEmpresas.buscarEmpresa("Guaymall�n"), empresa2);
		Assert.assertEquals(bolsaEmpresas.buscarEmpresa("Aguila"), empresa3);
	}
	
	@Test
	public void puedoObtenerInfoDeCuentas(){
		Cuenta cuenta = empresa1.getCuentas().get(0);
	    Assert.assertEquals(cuenta.getNombre(),"EDITBA");
	    Assert.assertEquals(cuenta.getValor(),1000);
	    Assert.assertEquals(cuenta.getPeriodo(),2010);
	}
	
}
