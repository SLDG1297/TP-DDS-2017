package Modelo.Metodologias.Condiciones;

import java.math.BigDecimal;

import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;

public class PromedioMenorA extends Promedio {

	public PromedioMenorA(Indicador indicador, Empresa empresa, BigDecimal valor) {
		super(indicador, empresa, valor);
	}
	
	@Override
	protected int booleano() {
		return -1;
	}
}
