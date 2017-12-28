package TestCargaBatchV2.TestContenedores;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatchV2.FuentesDeStrings.MockArchivo;
import Archivo.CargaBatchV2.Scanners.CSV;

public class TestContenedorDeStrings {
	ContenedorDeStrings contenedor;
	
	@Before
	public void iniciarContenedor() {
		String texto =	"Rolito,EDITBA,2000,8000\n" +
						"Axel's Consortium Bags,FCF,2017,6969";
		MockArchivo fuente  = new MockArchivo(texto);
		
		CSV scanner = new CSV(",");
		
		contenedor = new ContenedorDeStrings(fuente, scanner);
	}
	
	@Test
	public void sePuedeParsearExitosamente() throws IOException {
		EmpresaToken empresa1 = new EmpresaToken("Rolito", "EDITBA", "2000", "8000");
		EmpresaToken empresa2 = new EmpresaToken("Axel's Consortium Bags", "FCF", "2017", "6969");
		
		List<EmpresaToken> escaneo = contenedor.serEscaneado();
		
		EmpresaToken[] esperado = {empresa1, empresa2};
		EmpresaToken[] actual = {escaneo.get(0), escaneo.get(1)};
		
		assertArrayEquals(esperado, actual);
	}
}
