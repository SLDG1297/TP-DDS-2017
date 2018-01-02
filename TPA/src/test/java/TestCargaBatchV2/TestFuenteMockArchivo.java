package TestCargaBatchV2;

import static org.junit.Assert.*;

import org.junit.After;
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
		
		fuente.abrirse();
	}
	
	@After
	public void cerrarFuentes()
	{
		fuente.cerrarse();
	}
	
	@Test
	public void sePuedeDarUnString()
	{
		assertEquals("Rolito,EDITBA,2000,8000", fuente.darProximoString());
	}
	
	@Test
	public void sePuedenDarVariosStrings()
	{
		assertEquals("Rolito,EDITBA,2000,8000", fuente.darProximoString());
		assertEquals("Axel's Consortium Bags,FCF,2017,6969", fuente.darProximoString());
	}
	
	@Test
	public void siDoyUnStringDeLaFuenteDePruebaTodaviaQuedarianTokens()
	{
		fuente.darProximoString();
		
		assertTrue(fuente.quedanStrings());
	}
	
	@Test
	public void siDoyDosStringDeLaFuenteDePruebaNoQuedanMasTokens()
	{
		fuente.darProximoString();
		fuente.darProximoString();
		
		assertFalse(fuente.quedanStrings());
	}
	
	@Test
	public void darMasDeTresStringsMeDevuelveNulo()
	{
		fuente.darProximoString();
		fuente.darProximoString();
		
		assertNull(fuente.darProximoString());
	}
	
	@Test
	public void limpiarLaFuenteMeLaDejaVacia()
	{
		fuente.limpiarse();
		
		assertEquals("", fuente.getTexto());
	}
}
