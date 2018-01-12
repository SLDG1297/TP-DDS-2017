package TestCargaBatchV2;

import static org.junit.Assert.*;

import org.junit.Test;

import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.Cargadores.CargadorDeRepositorio;
import Archivo.CargaBatchV2.Contenedores.Contenedor;
import Archivo.CargaBatchV2.Excepciones.CantidadCamposIncorrectosException;
import Archivo.CargaBatchV2.ResultadosDeScan.ResultadoDeScan;
import Archivo.CargaBatchV2.ResultadosDeScan.ResultadoNegativo;
import Archivo.CargaBatchV2.ResultadosDeScan.ResultadoPositivo;

public class TestCargadores extends RepositorioDePruebaCargaBatchV2 {
	Contenedor contenedor;
	CargadorDeRepositorio cargador = new CargadorDeRepositorio();
	EmpresaToken token1 = new EmpresaToken("XD", "A", 2006, 105020);
	EmpresaToken token2 = new EmpresaToken("Khe", "Khe", 200, 20);
	
	private ResultadoDeScan resultadoPositivoFactory(EmpresaToken token) {
		return new ResultadoPositivo(token);
	}
	
	@Test
	public void puedoDeterminarQueExisteUnaEmpresaDadaEnElRepo() {
		assertTrue(cargador.existeLaCarga(token1));
	}
	
	@Test
	public void puedoDeterminarQueNoExisteUnaEmpresaDadaEnElRepo() {
		assertFalse(cargador.existeLaCarga(token2));
	}
	
	@Test
	public void puedoAniadirUnaEmpresa() {
		cargador.realizarAlta(token2);

		assertTrue(cargador.existeLaCarga(token2));
	}
	
	@Test
	public void puedoModificarUnaEmpresa() {
		cargador.realizarModificacion(token1);
		
		assertEquals(repositorio.buscarObjeto("XD").getPeriodos().get(0).getCuentas().get(0).getValor(), new Integer(105020));
	}
	
	@Test
	public void puedoAniadirDosEmpresasQueNoExistan() {
		cargador.cargar(resultadoPositivoFactory(new EmpresaToken("KheKheKhe", "A", 2006, 105020)));
		cargador.cargar(resultadoPositivoFactory(new EmpresaToken("YeahYeahYeah", "Khe", 200, 20)));
		
		assertEquals(4, repositorio.buscarListaDeObjetos().size());
	}
	
	@Test
	public void puedoModificarDosEmpresasQueExistan() {
		cargador.cargar(resultadoPositivoFactory(new EmpresaToken("XD", "A", 2006, 105020)));
		cargador.cargar(resultadoPositivoFactory(new EmpresaToken("DX", "Khe", 200, 20)));
		
		assertEquals(2, repositorio.buscarListaDeObjetos().size());
	}
	
	@Test
	public void puedoAniadirUnaEmpresaQueNoExisteYModificarOtra() {
		cargador.cargar(resultadoPositivoFactory(new EmpresaToken("XD", "A", 2006, 105020)));
		cargador.cargar(resultadoPositivoFactory(new EmpresaToken("KheKheKhe", "A", 2006, 105020)));
		
		assertEquals(3, repositorio.buscarListaDeObjetos().size());
	}
	
	@Test
	public void puedoAniadirUnaEmpresaQueNoExistaPrimeroDandolaDeAltaYLuegoModificandola() {
		cargador.cargar(resultadoPositivoFactory(new EmpresaToken("Ah s� s�", "A", 2006, 105020)));
		cargador.cargar(resultadoPositivoFactory(new EmpresaToken("Ah s� s�", "B", 2007, 11101)));
		
		assertEquals(3, repositorio.buscarListaDeObjetos().size());
	}
	
	@Test
	public void puedoIgnorarUnResultadoNegativo() {
		cargador.cargar(new ResultadoNegativo("Rip", new CantidadCamposIncorrectosException(5870)));
	}
}
