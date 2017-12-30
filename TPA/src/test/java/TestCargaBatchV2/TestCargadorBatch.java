package TestCargaBatchV2;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import Archivo.CargaBatchV2.Analizador;
import Archivo.CargaBatchV2.CargadorBatch;
import Archivo.CargaBatchV2.Contenedor;
import Archivo.CargaBatchV2.Analizadores.AnalizadorDeRepositorio;
import Archivo.CargaBatchV2.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatchV2.FuentesDeStrings.MockArchivo;
import Archivo.CargaBatchV2.Scanners.CSV;

public class TestCargadorBatch extends SetParaTestearAnalizadores {
	@Test
	public void probar() throws IOException {
		Contenedor contenedor = new ContenedorDeStrings(new MockArchivo("XD,A,2006,105020\nKhe,Khe,200,20"), new CSV(","));
		Analizador analizador = new AnalizadorDeRepositorio();
		
		CargadorBatch.cargar(contenedor, analizador);
		
		assertEquals(this.repositorio.buscarObjeto("XD").buscarPeriodo(2006).buscarCuenta("A").getValor(), new Integer(105020));
		assertTrue(this.repositorio.buscarObjeto("Khe") != null);
	}
}
