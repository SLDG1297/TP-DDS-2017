package TestCargaBatchV2;

import static org.junit.Assert.assertEquals;


import org.junit.Test;


import Archivo.CargaBatchV2.CargaBatch;
import Archivo.CargaBatchV2.Cargadores.Cargador;
import Archivo.CargaBatchV2.Cargadores.CargadorDeRepositorio;
import Archivo.CargaBatchV2.Contenedores.Contenedor;
import Archivo.CargaBatchV2.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatchV2.Excepciones.NoHayNadaException;
import Archivo.CargaBatchV2.FuentesDeStrings.MockArchivo;
import Archivo.CargaBatchV2.Scanners.CSV;

public class TestCargaBatch extends RepositorioDePruebaCargaBatchV2 {
	private Contenedor mock(String... texto) {
		return new ContenedorDeStrings(new MockArchivo(texto), new CSV(","));
	}
	
	private void ejecutarCarga(Contenedor contenedor) {
		Cargador cargador = new CargadorDeRepositorio();

		CargaBatch carga = new CargaBatch(contenedor, cargador);
		
		carga.cargar();
	}

	@Test
	public void puedoAgregarUnaEmpresa() {
		ejecutarCarga(mock("XD,A,2006,105020", "Khe,Khe,200,20"));
		
		assertEquals(3, repositorio.buscarListaDeObjetos().size());
	}
	
	@Test(expected = NoHayNadaException.class)
	public void elContenedorSeVaciaLuegoDeLaCarga() {
		Contenedor contenedor = mock("Khe,Khe,200,20");
		
		ejecutarCarga(contenedor);
		
		ejecutarCarga(contenedor);
	}
	
	@Test
	public void elContenedorVacioNoDeberiaHacerNadaCuandoRompeParaLaCargaAsincronica() {
		Cargador cargador = new CargadorDeRepositorio();

		CargaBatch carga = new CargaBatch(mock(), cargador);
		
		carga.run();
	}
}
