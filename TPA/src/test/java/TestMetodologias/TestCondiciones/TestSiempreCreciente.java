package TestMetodologias.TestCondiciones;

import org.junit.Assert;
import org.junit.Test;

import DB.EmpresasRepository;
import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.IndicadoresRepository;
import Modelo.Metodologias.Condiciones.Condicion;
import Modelo.Metodologias.Condiciones.SiempreCreciente;

public class TestSiempreCreciente extends TestCondiciones {
	
	@Test
	public void CumpleSi_LaEmpresaTiene_TodasLasCuenta() {
		
		Indicador indicador = IndicadoresRepository.getInstancia().getIndicadores().get(4);
		Condicion condicion = new SiempreCreciente(indicador, 5);
		Empresa empresa = EmpresasRepository.getInstancia().buscarEmpresa("Tecno");
		
		Assert.assertTrue(condicion.cumple(empresa));
	}
	
	@Test
	public void noCumpleSi_LaEmpresaNoTiene_AlgunaCuenta() {
		
		Indicador indicador = IndicadoresRepository.getInstancia().getIndicadores().get(4);
		Condicion condicion = new SiempreCreciente(indicador, 5);
		Empresa empresa = EmpresasRepository.getInstancia().buscarEmpresa("TecnoPlus");
		
		Assert.assertFalse(condicion.cumple(empresa));
	}
	
	@Test
	public void noCumpleCuando_ElIndicadorTieneSoloTieneUnNumero(){
		Indicador indicador = IndicadoresRepository.getInstancia().getIndicadores().get(3);
		Condicion condicion = new SiempreCreciente(indicador, 5);
		Empresa empresa = EmpresasRepository.getInstancia().buscarEmpresa("Tecno");
		
		Assert.assertFalse(condicion.cumple(empresa));
	}
	

}
