package Modelo.Indicadores;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "resta")
public class Resta extends Operacion {

	public Resta(Expresiones valorA) {
		super(valorA);
	}

	public Resta(Expresiones valorA, Expresiones valorB) {
		super(valorA, valorB);
	}

	@Override
	public BigDecimal realizarOperacion(Query query) {
		return this.valorA.calcular(query).subtract(this.valorB.calcular(query));
	}

	public String miOperador() {
		return "-";
	}
}