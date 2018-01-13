package TestCargaBatch;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import Archivo.CargaBatch.Cargadores.Cargador;
import Archivo.CargaBatch.Cargadores.CargadorDeRepositorio;
import Archivo.CargaBatch.CargasBatch.CargaBatch;
import Archivo.CargaBatch.CargasBatch.CargaBatchKelly;
import Archivo.CargaBatch.Contenedores.Contenedor;
import Archivo.CargaBatch.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatch.Excepciones.NoHayNadaException;
import Archivo.CargaBatch.FuentesDeStrings.MockArchivo;
import Archivo.CargaBatch.Scanners.CSV;

public class TestCargaBatch extends RepositorioDePruebaCargaBatch {
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
