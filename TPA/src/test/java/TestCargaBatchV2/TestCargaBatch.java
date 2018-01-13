package TestCargaBatchV2;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import Archivo.CargaBatchV2.Cargadores.Cargador;
import Archivo.CargaBatchV2.Cargadores.CargadorDeRepositorio;
import Archivo.CargaBatchV2.CargasBatch.CargaBatch;
import Archivo.CargaBatchV2.CargasBatch.CargaBatchKelly;
import Archivo.CargaBatchV2.Contenedores.Contenedor;
import Archivo.CargaBatchV2.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatchV2.Excepciones.NoHayNadaException;
import Archivo.CargaBatchV2.FuentesDeStrings.MockArchivo;
import Archivo.CargaBatchV2.Scanners.CSV;

public class TestCargaBatch extends RepositorioDePruebaCargaBatchV2 {
	private Contenedor mock(String... texto) {
		return new ContenedorDeStrings(new MockArchivo(texto), new CSV(","));
	}

	@Test
	public void puedoAgregarUnaEmpresa() {
		CargaBatch carga = new CargaBatch(mock("XD,A,2006,105020", "Khe,Khe,200,20"), new CargadorDeRepositorio());
		
		carga.cargar();
		
		assertEquals(3, repositorio.buscarListaDeObjetos().size());
	}
	
	@Test
	public void elContenedorNoSeVaciaLuegoDeLaCargaComun() {
		CargaBatch carga = new CargaBatch(mock("XD,A,2006,105020", "Khe,Khe,200,20"), new CargadorDeRepositorio());
		
		carga.cargar();
		
		carga.cargar();
	}
	
	@Test(expected = NoHayNadaException.class)
	public void elContenedorSeVaciaLuegoDeUnaCargaKelly(){
		CargaBatchKelly carga = new CargaBatchKelly(mock("XD,A,2006,105020", "Khe,Khe,200,20"), new CargadorDeRepositorio());
		
		carga.cargar();
		
		carga.cargar();
	}
	
	@Test
	public void elContenedorVacioNoDeberiaHacerNadaCuandoRompeParaLaCargaAsincronica() {
		Cargador cargador = new CargadorDeRepositorio();

		CargaBatchKelly carga = new CargaBatchKelly(mock(), cargador);
		
		carga.run();
	}
}
