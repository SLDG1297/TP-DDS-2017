package sistemaDeInversiones;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDominio {

	private BolsaComercial listaEmpresas = new BolsaComercial();
	private Empresa empresa1 = new Empresa("Jorgito");
	private Empresa empresa2 = new Empresa("Guaymallén");
	
	@Before
	public void crearBolsaComercialDePrueba(){
		listaEmpresas.agregarEmpresa(empresa1);
		listaEmpresas.agregarEmpresa(empresa2);
	}
	
	@Test
	public void SePuedenObtenerNombresDeEmpresas() {
		List<String> nombres = Arrays.asList("Jorgito", "Guaymallén");
		Assert.assertTrue(listaEmpresas.buscarNombresDeEmpresas() == nombres);
	}
	
	@Test
	public void SePuedenObtenerEmpresas(){
		Assert.assertTrue(listaEmpresas.buscarEmpresa("Jorgito") == empresa1);
	}

}
