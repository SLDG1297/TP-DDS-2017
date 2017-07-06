package Modelo.Metodologias.Condiciones;

import java.math.BigDecimal;

import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;

public class SumatoriaMayorA extends Sumatoria {

	public SumatoriaMayorA(Indicador indicador, BigDecimal valor) {
		super(indicador, valor);
	}

	@Override
	protected int booleano() {
		return 1;
	}

}
