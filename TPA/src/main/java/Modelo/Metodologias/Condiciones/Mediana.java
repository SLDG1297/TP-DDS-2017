package Modelo.Metodologias.Condiciones;

import java.math.BigDecimal;
import java.util.List;

import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Try;
import Modelo.Metodologias.Condiciones.Condicion;

public abstract class Mediana extends Condicion {

	protected BigDecimal valor;

	public Mediana(Indicador indicador, BigDecimal valor) {
		super(indicador);
		this.valor = valor;
	}

	@Override
	protected boolean fin(List<Try<BigDecimal>> success) {
		Double mediana = this.sum(success) / 2;
		return new BigDecimal(mediana).compareTo(valor) == this.booleano() || new BigDecimal(mediana).compareTo(valor) == 0; //Comparacion de BigDecimal
	}

}
