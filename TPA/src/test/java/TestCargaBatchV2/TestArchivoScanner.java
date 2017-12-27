package TestCargaBatchV2;

import static org.junit.Assert.*;
import org.junit.Test;

import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.Scanners.CSV;

public class TestArchivoScanner {
	CSV scanner = new CSV(",");
	
	@Test
	public void puedeEscanearConComa()
	{
		String renglon = "Rolito,EDITBA,2000,8000";
		EmpresaToken esperado = new EmpresaToken("Rolito", "EDITBA", 2000, 8000);
		
		assertTrue(esperado.esIgual(scanner.escanear(renglon)));
	}
	
	@Test
	public void puedeEscanearConOtraCosaTurbia()
	{
		CSV scanner = new CSV("@@");
		String renglon = "Rolito@@EDITBA@@2000@@8000";

		EmpresaToken esperado = new EmpresaToken("Rolito", "EDITBA", 2000, 8000);
		
		assertTrue(esperado.esIgual(scanner.escanear(renglon)));
	}
}
