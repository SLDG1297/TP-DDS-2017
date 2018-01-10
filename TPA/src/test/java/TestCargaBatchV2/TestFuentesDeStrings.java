package TestCargaBatchV2;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import Archivo.CargaBatchV2.RestauradorDeArchivo;
import Archivo.CargaBatchV2.FuentesDeStrings.Archivo;
import Archivo.CargaBatchV2.FuentesDeStrings.MockArchivo;

public class TestFuentesDeStrings {
	private MockArchivo mock;
	private static Archivo archivo;
	private static RestauradorDeArchivo restaurador;
	
	@Before
	public void iniciarFuentes()
	{
		mock = new MockArchivo("Rolito,EDITBA,2000,8000", "Axel's Consortium Bags,FCF,2017,6969");
		archivo = new Archivo("repositorioEmpresasMock.csv");
		restaurador = new RestauradorDeArchivo("repositorioEmpresasBackup.csv");
	}
	
	@AfterClass
	public static void restaurarFuentes()
	{
		restaurador.restaurar(archivo);
	}
	
	@Test
	public void sePuedenEscanearUnMock()
	{
		String[] esperado = {"Rolito,EDITBA,2000,8000", "Axel's Consortium Bags,FCF,2017,6969"};
		assertArrayEquals(esperado, mock.darLineas().toArray());
	}
	
	@Test
	public void sePuedeEscanearUnArchivo()
	{
		assertEquals(71, archivo.darLineas().size());
	}
	
	@Test
	public void siEscaneoDosVecesUnMismoArchivoNoObtengoMasLineas()
	{
		archivo.darLineas();
		
		assertEquals(0, archivo.darLineas().size());
	}
}
