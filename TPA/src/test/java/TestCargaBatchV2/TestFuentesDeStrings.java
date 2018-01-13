package TestCargaBatchV2;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import Archivo.CargaBatchV2.FuentesDeStrings.Archivo;
import Archivo.CargaBatchV2.FuentesDeStrings.MockArchivo;
import Archivo.CargaBatchV2.FuentesDeStrings.GestoresDeArchivo.GestorDeArchivo;
import Archivo.CargaBatchV2.FuentesDeStrings.GestoresDeArchivo.LimpiadorDeArchivo;
import Archivo.CargaBatchV2.FuentesDeStrings.GestoresDeArchivo.RestauradorDeArchivo;

public class TestFuentesDeStrings {
	private MockArchivo mock;
	private static Archivo archivo;
	private static GestorDeArchivo limpiador, restaurador;
	
	@Before
	public void iniciarFuentes()
	{
		mock = new MockArchivo("Rolito,EDITBA,2000,8000", "Axel's Consortium Bags,FCF,2017,6969");
		archivo = new Archivo("repositorioEmpresasMock.csv");
		limpiador = new LimpiadorDeArchivo();
		restaurador = new RestauradorDeArchivo("repositorioEmpresasBackup.csv");
	}
	
	@AfterClass
	public static void restaurarFuentes()
	{
		
		restaurador.atender(archivo);
	}
	
	@Test
	public void sePuedenEscanearUnMock()
	{
		String[] esperado = {"Rolito,EDITBA,2000,8000", "Axel's Consortium Bags,FCF,2017,6969"};
		assertArrayEquals(esperado, mock.darLineas().toArray());
	}
	
	@Test
	public void unMockConAlgoNoEstaVacio()
	{
		assertFalse(mock.noTieneLineas());
	}

	public void unMockVacioMeTiraQueNoHayNadaQueEscanear()
	{
		assertTrue(new MockArchivo().noTieneLineas());
	}
	
	@Test
	public void sePuedeEscanearUnArchivo()
	{
		assertEquals(71, archivo.darLineas().size());
	}
	
	@Test
	public void siEscaneoDosVecesUnMismoArchivoLimpiadoNoObtengoMasLineas()
	{
		archivo.darLineas();
		
		limpiador.atender(archivo);
		
		assertTrue(archivo.noTieneLineas());
	}
}
