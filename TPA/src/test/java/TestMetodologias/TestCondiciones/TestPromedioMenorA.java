package TestMetodologias.TestCondiciones;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

import DB.Repositorios.EmpresasRepository;
import DB.Repositorios.IndicadoresRepository;
import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Condiciones.Condicion;
import Modelo.Metodologias.Condiciones.CondicionFactory;

public class TestPromedioMenorA extends TestCondiciones {
	
	@Test
	public void CumpleSi_LaEmpresaTiene_TodasLasCuenta() {
		
		Indicador indicador = IndicadoresRepository.getInstancia().getIndicadores().get(4);
		Condicion condicion = new CondicionFactory().crearPromedioMenorA(indicador, new BigDecimal(20000));
		Empresa empresa = EmpresasRepository.getInstancia().buscarEmpresa("Rolito");
		
		Assert.assertTrue(condicion.cumple(empresa));
	}
	
	
	@Test
	public void noCumpleSi_LaEmpresaNoTiene_AlgunaCuenta() {
		
		Indicador indicador = IndicadoresRepository.getInstancia().getIndicadores().get(4);
		Condicion condicion = new CondicionFactory().crearPromedioMenorA(indicador, new BigDecimal(1));
		Empresa empresa = EmpresasRepository.getInstancia().buscarEmpresa("Rip SA");
		
		Assert.assertFalse(condicion.cumple(empresa));
	}
	
	
	@Test
	public void cumpleSiElPromedio_DelIndicadorQueSoloTieneUnNumero_EsMenorAlQuePusoElUsuario(){
		Indicador indicador = IndicadoresRepository.getInstancia().getIndicadores().get(3);
		Condicion condicion = new CondicionFactory().crearPromedioMenorA(indicador, new BigDecimal(20000));
		Empresa empresa = EmpresasRepository.getInstancia().buscarEmpresa("Rolito");
		
		Assert.assertTrue(condicion.cumple(empresa));
	}
	
	@Test
	public void noCumpleSiElPromedio_DelIndicadorQueSoloTieneUnNumero_EsMayorAlQuePusoElUsuario(){
		Indicador indicador = IndicadoresRepository.getInstancia().getIndicadores().get(3);
		Condicion condicion = new CondicionFactory().crearPromedioMenorA(indicador, new BigDecimal(1));
		Empresa empresa = EmpresasRepository.getInstancia().buscarEmpresa("Rolito");
		
		Assert.assertFalse(condicion.cumple(empresa));
	}
	
	@Test
	public void cumpleSiElPromedio_DelIndicadorQueTieneOtroIndicadorDentro_EsMenorAlQuePusoElUsuario(){
		Indicador indicador = IndicadoresRepository.getInstancia().getIndicadores().get(2);
		Condicion condicion = new CondicionFactory().crearPromedioMenorA(indicador, new BigDecimal(20000));
		Empresa empresa = EmpresasRepository.getInstancia().buscarEmpresa("Rolito");
		
		Assert.assertTrue(condicion.cumple(empresa));
	}
	
	@Test
	public void noCumpleSiElPromedio_DelIndicadorQueTieneOtroIndicadorDentro_EsMayorAlQuePusoElUsuario(){
		Indicador indicador = IndicadoresRepository.getInstancia().getIndicadores().get(2);
		Condicion condicion = new CondicionFactory().crearPromedioMenorA(indicador, new BigDecimal(1));
		Empresa empresa = EmpresasRepository.getInstancia().buscarEmpresa("Rolito");
		
		Assert.assertFalse(condicion.cumple(empresa));
	}
	
	@Test
	public void cumpleSiElPromedio_DelIndicadorQueTieneOperacionesrDentro_EsMenorAlQuePusoElUsuario(){
		Indicador indicador = IndicadoresRepository.getInstancia().getIndicadores().get(5);
		Condicion condicion = new CondicionFactory().crearPromedioMenorA(indicador, new BigDecimal(80000));
		Empresa empresa = EmpresasRepository.getInstancia().buscarEmpresa("Rolito");
		
		Assert.assertTrue(condicion.cumple(empresa));
	}
	
	@Test
	public void noCumpleSiElPromedio_DelIndicadorQueTieneOperacionesrDentro_EsMayorAlQuePusoElUsuario(){
		Indicador indicador = IndicadoresRepository.getInstancia().getIndicadores().get(5);
		Condicion condicion = new CondicionFactory().crearPromedioMenorA(indicador, new BigDecimal(1));
		Empresa empresa = EmpresasRepository.getInstancia().buscarEmpresa("Rolito");
		
		Assert.assertFalse(condicion.cumple(empresa));
	}

}
