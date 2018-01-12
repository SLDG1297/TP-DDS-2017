package TestCargaBatchV2;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Archivo.CargaBatchV2.CargaBatch;
import Archivo.CargaBatchV2.Cronometro;
import Archivo.CargaBatchV2.Cargadores.Cargador;
import Archivo.CargaBatchV2.Cargadores.CargadorDeRepositorio;
import Archivo.CargaBatchV2.Contenedores.Contenedor;
import Archivo.CargaBatchV2.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatchV2.FuentesDeStrings.MockArchivo;
import Archivo.CargaBatchV2.Scanners.CSV;

public class TestCronometro extends RepositorioDePruebaCargaBatchV2 {
	CargaBatch cargaBatch;
	Cronometro cron;
	
	@Before
	public void iniciarFuentes() throws FileNotFoundException {
		Contenedor contenedor = new ContenedorDeStrings(new MockArchivo("XD,A,2006,105020", "Khe,Khe,200,20"), new CSV(","));

		Cargador cargador = new CargadorDeRepositorio();

		cargaBatch = new CargaBatch(contenedor, cargador);
		
		cron = new Cronometro();
		
		cron.ejecutaPeriodicamente(cargaBatch, 50);
	}
	
	@After
	public void terminarTareas() {
		cron.terminarTareas();
	}
	
	@Test
	public void puedoAgregarUnaEmpresaTrasUnLapsoDeTiempo() throws InterruptedException {
		Thread.sleep(100);

		assertEquals(3, repositorio.buscarListaDeObjetos().size());
	}
	
	@Test
	public void puedoReescribirElContenedorYQueTomeLoNuevo() throws InterruptedException {
		Thread.sleep(200);
		
		cargaBatch.setContenedor(new ContenedorDeStrings(new MockArchivo("XD,Yeah,2010,5700", "Ah,SiSi,500,8000", "QEPD,RIP,500,600"), new CSV(",")));
		
		Thread.sleep(200);
		
		assertEquals(5, repositorio.buscarListaDeObjetos().size());
	}
}
