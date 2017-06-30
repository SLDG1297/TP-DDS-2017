package Modelo.Metodologias.Condiciones;

import java.math.BigDecimal;

import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Condiciones.Booleana;

public class MayorAEnPeriodos extends Booleana{

	public MayorAEnPeriodos(Indicador indicador, Empresa empresa, BigDecimal valor, int anios) {
		super(indicador, empresa, valor, anios);
	}

	@Override
	protected int booleano() {
		return 1;
	}
	

}
