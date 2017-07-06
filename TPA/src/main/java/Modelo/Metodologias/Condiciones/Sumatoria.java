package Modelo.Metodologias.Condiciones;

import java.math.BigDecimal;
import java.util.List;

import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Try;
import Modelo.Metodologias.Condiciones.Condicion;

public abstract class Sumatoria extends Condicion {

	protected BigDecimal valor;

	public Sumatoria(Indicador indicador, BigDecimal valor) {
		super(indicador);
		this.valor = valor;
	}

	@Override
	protected boolean fin(List<Try<BigDecimal>> success) {
		double sumatoria = this.sum(success); 
		return new BigDecimal(sumatoria).compareTo(valor) == this.booleano() || new BigDecimal(sumatoria).compareTo(valor) == 0; //Comparacion de BigDecimal
	}

}
