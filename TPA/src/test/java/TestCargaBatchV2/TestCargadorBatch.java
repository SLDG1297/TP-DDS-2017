package TestCargaBatchV2;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import Archivo.CargaBatchV2.Analizador;
import Archivo.CargaBatchV2.CargadorBatch;
import Archivo.CargaBatchV2.Contenedor;
import Archivo.CargaBatchV2.Analizadores.AnalizadorDeRepositorio;
import Archivo.CargaBatchV2.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatchV2.FuentesDeStrings.Archivo;
import Archivo.CargaBatchV2.FuentesDeStrings.MockArchivo;
import Archivo.CargaBatchV2.Scanners.CSV;

public class TestCargadorBatch extends SetParaTestearAnalizadores {
	static Contenedor contenedor1, contenedor2;
	
	private void carga(Contenedor contenedor) throws IOException {
		Analizador analizador = new AnalizadorDeRepositorio();
		
		CargadorBatch.cargarMock(contenedor, analizador);
	}
	
	@Before
	public void iniciarFuentes() throws FileNotFoundException {
		contenedor1 = new ContenedorDeStrings(new MockArchivo("XD,A,2006,105020\nKhe,Khe,200,20"), new CSV(","));
		contenedor2 = new ContenedorDeStrings(new Archivo("repositorioEmpresasMock.csv", "repositorioEmpresasBackup.csv"), new CSV(","));
	}
	
	@Test
	public void cargaExitosaDesdeMock() throws IOException {
		carga(contenedor1);
		
		assertEquals(this.repositorio.buscarObjeto("XD").buscarPeriodo(2006).buscarCuenta("A").getValor(), new Integer(105020));
		assertNotNull(this.repositorio.buscarObjeto("Khe"));
	}
	
	@Test
	public void cargarDesdeArchivo() throws IOException {
		carga(contenedor2);
		
		assertTrue(this.repositorio.buscarListaDeObjetos().size() == 8);
	}
	
	@AfterClass
	public static void restaurarArchivo() throws IOException {
		contenedor1.limpiarse();
		contenedor2.limpiarse();
		contenedor1.restaurarse();
		contenedor2.restaurarse();
		contenedor1.cerrarse();
		contenedor1.cerrarse();
	}
}
