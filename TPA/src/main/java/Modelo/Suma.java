package Modelo;

import java.math.BigDecimal;

public class Suma extends Operacion {

	public Suma(Expresion valorA) {
		super(valorA);
	}

	public Suma(Expresion valorA, Expresion valorB) {
		super(valorA, valorB);
	}

	@Override
	public BigDecimal calcular(Query query) {
		this.sePuedeCalcular();
		return this.valorA.calcular(query).add(this.valorB.calcular(query));
	}
}
