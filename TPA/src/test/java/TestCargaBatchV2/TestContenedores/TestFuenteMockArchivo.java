package TestCargaBatchV2.TestContenedores;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import Archivo.CargaBatchV2.FuentesDeStrings.MockArchivo;

public class TestFuenteMockArchivo {
	private MockArchivo fuente;
	
	@Before
	public void iniciarFuentes()
	{
		String texto =	"Rolito,EDITBA,2000,8000\n" +
						"Axel's Consortium Bags,FCF,2017,6969";
		fuente = new MockArchivo(texto);
	}
	
	@Test
	public void sePuedeDarUnString() throws IOException
	{
		assertEquals("Rolito,EDITBA,2000,8000", fuente.darProximoString());
	}
	
	@Test
	public void sePuedenDarVariosStrings() throws IOException
	{
		assertEquals("Rolito,EDITBA,2000,8000", fuente.darProximoString());
		assertEquals("Axel's Consortium Bags,FCF,2017,6969", fuente.darProximoString());
	}
	
	@Test
	public void siDoyUnStringDeLaFuenteDePruebaTodaviaQuedarianTokens() throws IOException
	{
		fuente.darProximoString();
		
		assertTrue(fuente.quedanStrings());
	}
	
	@Test
	public void siDoyDosStringDeLaFuenteDePruebaNoQuedanMasTokens() throws IOException
	{
		fuente.darProximoString();
		fuente.darProximoString();
		
		assertFalse(fuente.quedanStrings());
	}
	
	@Test
	public void darMasDeTresStringsMeDevuelveNulo() throws IOException
	{
		fuente.darProximoString();
		fuente.darProximoString();
		
		assertNull(fuente.darProximoString());
	}
	
	@Test
	public void limpiarLaFuenteMeLaDejaVacia() throws IOException
	{
		fuente.limpiarse();
		
		assertEquals("", fuente.getTexto());
	}
}
