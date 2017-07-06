package Modelo.Metodologias.Condiciones;

import java.math.BigDecimal;

import Modelo.Indicadores.Indicador;

public class PromedioMayorA extends Promedio{

	public PromedioMayorA(Indicador indicador, BigDecimal valor) {
		super(indicador, valor);
	}

	@Override
	protected int booleano() {
		return 1;
	}
}
