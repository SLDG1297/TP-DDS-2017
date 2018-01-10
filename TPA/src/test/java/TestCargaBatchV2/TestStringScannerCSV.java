package TestCargaBatchV2;

import static org.junit.Assert.*;

import org.junit.Test;

import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.Scanners.CSV;

public class TestStringScannerCSV {
	CSV scanner = new CSV(",");
	
	private void tieneQueSerFalso(String renglon) {
		assertFalse(scanner.esLineaValida(renglon));
	}
	
	@Test
	public void CSVPuedeEscanearConComa()
	{
		String renglon = "Rolito,EDITBA,2000,8000";
		EmpresaToken esperado = new EmpresaToken("Rolito", "EDITBA", 2000, 8000);
		
		assertEquals(esperado, scanner.escanear(renglon));
	}
	
	@Test
	public void CSVPuedeEscanearConOtraCosaTurbia()
	{
		CSV scannerTurbio = new CSV("@@");
		String renglon = "Rolito@@EDITBA@@2000@@8000";

		EmpresaToken esperado = new EmpresaToken("Rolito", "EDITBA", 2000, 8000);
		
		assertEquals(esperado, scannerTurbio.escanear(renglon));
	}
	
	@Test
	public void CSVRompeCuandoPongoAlgoVacio()
	{
		tieneQueSerFalso("");
	}
	
	@Test
	public void CSVRompeCuandoNoHayDelimitadores()
	{
		tieneQueSerFalso("Rolito");
	}
	
	@Test
	public void CSVRompeCuandoFaltan3Campos()
	{
		tieneQueSerFalso("Rolito,");
	}
	
	@Test
	public void CSVRompeCuandoFaltan2Campos()
	{
		tieneQueSerFalso("Rolito,EDITBA");
	}
	
	@Test
	public void CSVRompeCuandoFalta1Campo()
	{
		tieneQueSerFalso("Rolito,EDITBA,2000");
	}
	
	@Test
	public void CSVRompeCuandoHayCamposDeMas()
	{
		tieneQueSerFalso("Rolito,EDITBA,2000,8000,Khe");
	}
	
	@Test
	public void CSVRompeCuandoElDelimitadorEsCualquiera()
	{
		tieneQueSerFalso("Rolito/EDITBA/2000/8000");
	}
}
