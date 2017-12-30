package TestCargaBatchV2;

import org.junit.Assert;
import org.junit.Test;

import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.Cargas.Alta;
import Archivo.CargaBatchV2.Cargas.Modificacion;

public class TestTiposDeCargas extends SetParaTestearAnalizadores {
	@Test
	public void sePuedeDarDeAltaUnaEmpresa() {
		alta = new Alta(new EmpresaToken("Nueva", "Comiendola doblada", 2008, 5566));
		
		alta.efectuarse();
		
		Assert.assertEquals("Nueva", repositorio.buscarObjeto("Nueva").getNombre());
	}
	
	@Test
	public void sePuedeModificarUnaEmpresa() {
		modificacion = new Modificacion(new EmpresaToken("XD", "Comiendola doblada", 2008, 5566));
		
		modificacion.efectuarse();
		
		Assert.assertNotNull(empresa1.buscarPeriodo(2008));
	}
}
