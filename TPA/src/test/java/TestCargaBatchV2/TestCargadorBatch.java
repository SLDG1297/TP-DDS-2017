package TestCargaBatchV2;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import Archivo.CargaBatchV2.Analizador;
import Archivo.CargaBatchV2.Cargador;
import Archivo.CargaBatchV2.Contenedor;
import Archivo.CargaBatchV2.Analizadores.AnalizadorDeRepositorio;
import Archivo.CargaBatchV2.Cargadores.CargadorBatch;
import Archivo.CargaBatchV2.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatchV2.FuentesDeStrings.Archivo;
import Archivo.CargaBatchV2.FuentesDeStrings.MockArchivo;
import Archivo.CargaBatchV2.Scanners.CSV;

public class TestCargadorBatch extends SetParaTestearAnalizadores {
	static Cargador cargadorMock, cargadorBatch;
	
	@Before
	public void iniciarFuentes() throws FileNotFoundException {
		Contenedor contenedor1 = new ContenedorDeStrings(new MockArchivo("XD,A,2006,105020\nKhe,Khe,200,20"), new CSV(","));
		Contenedor contenedor2 = new ContenedorDeStrings(new Archivo("repositorioEmpresasMock.csv", "repositorioEmpresasBackup.csv"), new CSV(","));
		
		Analizador analizador1 = new AnalizadorDeRepositorio();
		Analizador analizador2 = new AnalizadorDeRepositorio();
		
		cargadorMock = new CargadorBatch(contenedor1, analizador1);
		cargadorBatch = new CargadorBatch(contenedor2, analizador2);
	}
	
	@Test
	public void cargaExitosaDesdeMock() {
		cargadorMock.cargar();
		
		assertEquals(this.repositorio.buscarObjeto("XD").buscarPeriodo(2006).buscarCuenta("A").getValor(), new Integer(105020));
		assertNotNull(this.repositorio.buscarObjeto("Khe"));
	}
	
	@Test
	public void siVuelvoAEscanearUnContenedorNoPasaNada() {
		cargadorMock.cargar();
		cargadorMock.cargar();
	}
	
	@Test
	public void cargarDesdeArchivo() {
		cargadorBatch.cargar();
		
		assertTrue(this.repositorio.buscarListaDeObjetos().size() == 8);
	}
	
	@AfterClass
	public static void restaurarArchivo() {
		cargadorMock.procesoPosterior();
		cargadorBatch.procesoPosterior();
		
		cargadorMock.getContenedor().restaurarse();
		cargadorBatch.getContenedor().restaurarse();
	}
}
