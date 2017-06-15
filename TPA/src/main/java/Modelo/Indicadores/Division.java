package Modelo.Indicadores;

import java.math.BigDecimal;

public class Division extends Operacion {

	public Division(Expresion valorA) {
		super(valorA);
	}

	public Division(Expresion valorA, Expresion valorB) {
		super(valorA, valorB);
	}

	@Override
	public BigDecimal realizarOperacion(Query query) {
		return this.valorA.calcular(query).divide(this.valorB.calcular(query));
	}

}
