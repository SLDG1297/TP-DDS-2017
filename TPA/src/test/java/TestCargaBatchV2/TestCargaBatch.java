package TestCargaBatchV2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Archivo.CargaBatchV2.CargaBatch;
import Archivo.CargaBatchV2.Cargadores.Cargador;
import Archivo.CargaBatchV2.Cargadores.CargadorDeRepositorio;
import Archivo.CargaBatchV2.Contenedores.Contenedor;
import Archivo.CargaBatchV2.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatchV2.FuentesDeStrings.MockArchivo;
import Archivo.CargaBatchV2.Scanners.CSV;

public class TestCargaBatch extends RepositorioDePruebaCargaBatchV2 {
	private void ejecutarCarga(String... texto) {
		Contenedor contenedor = new ContenedorDeStrings(new MockArchivo(texto), new CSV(","));

		Cargador cargador = new CargadorDeRepositorio();

		CargaBatch carga = new CargaBatch(contenedor, cargador);
		
		carga.run();
	}
	
	@Test
	public void puedoAgregarUnaEmpresa() {
		ejecutarCarga("XD,A,2006,105020", "Khe,Khe,200,20");
		
		assertEquals(3, repositorio.buscarListaDeObjetos().size());
	}
	
	@Test
	public void noPasaNadaSiNoHayNada() {
		ejecutarCarga();
		
		assertEquals(2, repositorio.buscarListaDeObjetos().size());
	}
}
