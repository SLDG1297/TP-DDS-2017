package sistemaDeInversiones;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDominio {

	private BolsaComercial bolsaComercial = new BolsaComercial();
	private Empresa empresa1 = new Empresa("Jorgito");
	private Empresa empresa2 = new Empresa("Guaymallén");
	private List<Empresa> listaEmpresas = Arrays.asList(empresa1, empresa2);

	@Before
	public void crearBolsaComercialDePrueba() {
		bolsaComercial.setEmpresas(listaEmpresas);
	}

	@Test
	public void SePuedenObtenerNombresDeEmpresas() {
		List<String> nombres = Arrays.asList("Jorgito", "Guaymallén");
		Assert.assertEquals(bolsaComercial.buscarNombresDeEmpresas(), nombres);
	}

	@Test
	public void SePuedenObtenerEmpresas() {
		Assert.assertEquals(bolsaComercial.buscarEmpresa("Jorgito"), empresa1);
	}
	
}
