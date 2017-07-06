package Metodologias;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Archivo.Empresa.Instanciador_Bolsa_Empresas;
import Archivo.Indicadores.AlmacenadorDeIndicadores;
import Modelo.Empresa.BolsaDeEmpresas;
import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.IndicadoresRepository;
import Modelo.Metodologias.Condiciones.Condicion;
import Modelo.Metodologias.Condiciones.MayorAEnPeriodos;

public class TestCondiciones {
	
	@Before
	public void x() throws IOException{
	new Instanciador_Bolsa_Empresas().instanciar();
	AlmacenadorDeIndicadores.getInstancia().obtenerRepositorioIndicadores();
	}
	
	@Test
	public void aplicarMayorAListaVacia() {
		List<Integer> list = new ArrayList<Integer>();
		
		Assert.assertEquals(true, list.stream().allMatch(num -> num >2));			
	}
	
	@Test
	public void mayorAEnPeriodosCONTodasLasCuentas() {
		
		Indicador indicador = IndicadoresRepository.getInstancia().getIndicadores().get(4);
		Condicion condicion = new MayorAEnPeriodos(indicador, new BigDecimal(1), 1);
		Empresa empresa = BolsaDeEmpresas.getInstancia().buscarEmpresa("Rolito");
		
		Assert.assertTrue(condicion.cumple(empresa));
	}
	
	
	@Test
	public void mayorAEnPeriodosSINTodasLasCuentas() {
		
		Indicador indicador = IndicadoresRepository.getInstancia().getIndicadores().get(4);
		Condicion condicion = new MayorAEnPeriodos(indicador, new BigDecimal(1115000), 1);
		Empresa empresa = BolsaDeEmpresas.getInstancia().buscarEmpresa("Rip SA");
		
		Assert.assertFalse(condicion.cumple(empresa));
	}
	
	@Test
	public void mayorAEnPeriodos_FueraDelrangoDeLosPeriodosQuePusoElUsuario() {
		
		Indicador indicador = IndicadoresRepository.getInstancia().getIndicadores().get(4);
		Condicion condicion = new MayorAEnPeriodos(indicador, new BigDecimal(1), 15);
		Empresa empresa = BolsaDeEmpresas.getInstancia().buscarEmpresa("Rolito");
		
		Assert.assertTrue(condicion.cumple(empresa));
	}
}
		
