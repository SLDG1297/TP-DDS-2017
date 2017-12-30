package TestCargaBatchV2;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import Archivo.CargaBatchV2.Carga;
import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.Analizadores.AnalizadorDeRepositorio;
import Archivo.CargaBatchV2.Cargas.Alta;
import Archivo.CargaBatchV2.Cargas.Modificacion;
import Archivo.CargaBatchV2.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatchV2.FuentesDeStrings.MockArchivo;
import Archivo.CargaBatchV2.Scanners.CSV;

public class TestAnalizadores extends SetParaTestearAnalizadores {
	AnalizadorDeRepositorio analizador = new AnalizadorDeRepositorio();
	EmpresaToken token1 = new EmpresaToken("XD", "A", 2006, 105020);
	EmpresaToken token2 = new EmpresaToken("Khe", "Khe", 200, 20);
	
	private List<Carga> resultadoDeAnalisis(String texto) throws IOException {
		List<EmpresaToken> tokens = new ContenedorDeStrings(new MockArchivo(texto), new CSV(",")).serEscaneado();
		
		return analizador.analizarContenedor(tokens);
	}
	
	@Test
	public void puedoDeterminarQueExisteUnaEmpresaDada() {
		assertTrue(analizador.existeLaCarga(token1));
	}
	
	@Test
	public void puedoDeterminarQueNoExisteUnaEmpresaDada() {
		assertFalse(analizador.existeLaCarga(token2));
	}
	
	@Test
	public void puedoAniadirUnTokenSiNoExiste() {
		analizador.analizarToken(token2);
		
		analizador.getCargas().get(0).efectuarse();

		assertTrue(analizador.existeLaCarga(token2));
	}
	
	@Test
	public void puedoModificarUnTokenSiNoExiste() {
		analizador.analizarToken(token1);
		
		analizador.getCargas().get(0).efectuarse();
		
		assertEquals(repositorio.buscarObjeto("XD").getPeriodos().get(0).getCuentas().get(0).getValor(), new Integer(105020));
	}
	
	@Test
	public void puedoAnalizarUnContenedorYQueMeGenereDosCargas() throws IOException {
		List<Carga> cargas = resultadoDeAnalisis("XD,A,2006,105020\nKhe,Khe,200,20");
		
		assertTrue(cargas.size() == 2);
	}
	
	@Test
	public void dosTokensDeEmpresasInexistentesDanDosAltas() throws IOException {
		List<Carga> cargas = resultadoDeAnalisis("KheKheKhe,A,2006,105020\nYeahYeahYeah,Khe,200,20");
		
		assertTrue(cargas.stream().allMatch(c -> c.getClass().equals(Alta.class)));
	}
	
	@Test
	public void dosTokensDeEmpresasExistentesDanDosModificaciones() throws IOException {
		List<Carga> cargas = resultadoDeAnalisis("XD,C,2006,2000\nXD,D,2006,3000");
		
		assertTrue(cargas.stream().allMatch(c -> c.getClass().equals(Modificacion.class)));
	}
	
	@Test
	public void dosTokensDeEmpresasInexistentesMeDanUnAltaYUnaModificacion() throws IOException {
		List<Carga> cargas = resultadoDeAnalisis("Khe,Khe,2001,20\nKhe,Khe,2002,21");
		
		assertTrue(cargas.get(0).getClass().equals(Alta.class) && cargas.get(1).getClass().equals(Modificacion.class));
	}
}
