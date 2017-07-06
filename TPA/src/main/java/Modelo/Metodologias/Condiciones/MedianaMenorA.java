package Modelo.Metodologias.Condiciones;

import java.math.BigDecimal;

import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;

public class MedianaMenorA extends Mediana {

	public MedianaMenorA(Indicador indicador, BigDecimal valor) {
		super(indicador, valor);
	}

	@Override
	protected int booleano() {
		return -1;
	}

}
