package Modelo.Metodologias;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.Query;

public class MayorAValor extends Condicion{
	
	private Indicador indicador;
	private Empresa empresa;
	private BigDecimal valor;
	private int anios;
	
	public MayorAValor(Indicador indicador, Empresa empresa, BigDecimal valor, int anios) {
		super(indicador, empresa);
		this.valor = valor;
		this.anios = anios;
	}

	@Override
	public List<Periodo> inicio(List<Periodo> lista) {
		return lista.stream().filter(periodo -> periodo.estaEntre(actual, anios)).collect(Collectors.toList());
	}
	
	@Override
	public boolean fin(List<Success<BigDecimal>> success) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
