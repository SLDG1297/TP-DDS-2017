package TestCargaBatchV2.TestContenedores;

import static org.junit.Assert.*;

import org.junit.Test;

import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.Excepciones.DeScaneo.CantidadCamposIncorrectosException;
import Archivo.CargaBatchV2.Excepciones.DeScaneo.RenglonVacioException;
import Archivo.CargaBatchV2.Scanners.CSV;

public class TestStringScannerCSV {
	CSV scanner = new CSV(",");
	
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
	
	@Test(expected = RenglonVacioException.class)
	public void CSVRompeCuandoPongoAlgoVacio()
	{
		scanner.escanear("");
	}
	
	@Test(expected = CantidadCamposIncorrectosException.class)
	public void CSVRompeCuandoNoHayDelimitadores()
	{
		scanner.escanear("Rolito");
	}
	
	@Test(expected = CantidadCamposIncorrectosException.class)
	public void CSVRompeCuandoFaltan3Campos()
	{
		scanner.escanear("Rolito,");
	}
	
	@Test(expected = CantidadCamposIncorrectosException.class)
	public void CSVRompeCuandoFaltan2Campos()
	{
		scanner.escanear("Rolito,EDITBA");
	}
	
	@Test(expected = CantidadCamposIncorrectosException.class)
	public void CSVRompeCuandoFalta1Campo()
	{
		scanner.escanear("Rolito,EDITBA,2000");
	}
	
	@Test(expected = CantidadCamposIncorrectosException.class)
	public void CSVRompeCuandoHayCamposDeMas()
	{
		scanner.escanear("Rolito,EDITBA,2000,8000,Khe");
	}
	
	@Test(expected = CantidadCamposIncorrectosException.class)
	public void CSVRompeCuandoElDelimitadorEsCualquiera()
	{
		scanner.escanear("Rolito/EDITBA/2000/8000");
	}
}