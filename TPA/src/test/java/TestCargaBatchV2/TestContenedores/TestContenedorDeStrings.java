package TestCargaBatchV2.TestContenedores;

import org.junit.Before;

import Archivo.CargaBatchV2.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatchV2.FuentesDeStrings.MockArchivo;
import Archivo.CargaBatchV2.Scanners.CSV;

public class TestContenedorDeStrings {
	ContenedorDeStrings contenedor;
	
	@Before
	public void iniciarContenedor() {
		String texto =	"Rolito,EDITBA,2000,8000\nAxel's Consortium Bags,FCF,2017,6969";
		MockArchivo fuente  = new MockArchivo(texto);
		
		CSV scanner = new CSV(",");
		
		// Iniciar Manejador
		
		// contenedor = new ContenedorDeStrings(fuente, scanner, manejador);
	}
}
