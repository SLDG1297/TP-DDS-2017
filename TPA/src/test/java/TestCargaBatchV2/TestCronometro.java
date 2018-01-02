package TestCargaBatchV2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Archivo.CargaBatchV2.Analizador;
import Archivo.CargaBatchV2.Cargador;
import Archivo.CargaBatchV2.Contenedor;
import Archivo.CargaBatchV2.Cronometro;
import Archivo.CargaBatchV2.FuenteDeStrings;
import Archivo.CargaBatchV2.StringScanner;
import Archivo.CargaBatchV2.Analizadores.AnalizadorDeRepositorio;
import Archivo.CargaBatchV2.Cargadores.CargadorMock;
import Archivo.CargaBatchV2.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatchV2.FuentesDeStrings.MockArchivo;
import Archivo.CargaBatchV2.Scanners.CSV;
import DB.Proveedores.ProveedorMock;
import DB.Repositorios.RepositorioEmpresas;
import Modelo.Empresa.Empresa;

public class TestCronometro {
	private FuenteDeStrings fuente;
	private StringScanner scanner;
	private Contenedor contenedor;
	private Analizador analizador;
	private Cargador tarea;
	private Cronometro cron;
	private RepositorioEmpresas repositorio;
	
	@Before
	public void iniciarTareas() {
		repositorio = RepositorioEmpresas.getInstancia();
		repositorio.setProveedor(new ProveedorMock<Empresa>());
		
		fuente = new MockArchivo("Rolito,EDITBA,2000,8000\nAxel's Consortium Bags,FCF,2017,6969");
		scanner = new CSV(",");
		
		contenedor = new ContenedorDeStrings(fuente, scanner);
		analizador = new AnalizadorDeRepositorio();
		tarea = new CargadorMock(contenedor, analizador);
		
		cron = new Cronometro();
		
		
	}
	
	@After
	public void terminarTareas() {
		cron.terminarTareas();
	}
	
	@Test
	public void puedoAgregarUnaEmpresaTrasUnLapsoDeTiempo() throws InterruptedException {
		cron.ejecutaPeriodicamente(tarea, 10);
		
		Thread.sleep(100);
		
		assertEquals(2, repositorio.buscarListaDeObjetos().size());
	}
	
	@Test
	public void puedoReescribirElContenedorYQueTomeLoNuevo() throws InterruptedException {
		cron.ejecutaPeriodicamente(tarea, 10);
		
		Thread.sleep(200);
		
		fuente = new MockArchivo("Yeah,Yeah,2010,5700");
		
		Thread.sleep(200);
		
		assertEquals(3, repositorio.buscarListaDeObjetos().size());
	}
}
