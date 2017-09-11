package Modelo.Indicadores;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "multiplicaciones")
public class Multiplicacion extends Operacion {
	
	public Multiplicacion(Expresiones valorA) {
		super(valorA);
	}

	public Multiplicacion(Expresiones valorA, Expresiones valorB) {
		super(valorA, valorB);
	}

	@Override
	public BigDecimal realizarOperacion(Query query) {
		return this.valorA.calcular(query).multiply(this.valorB.calcular(query));
	}

	public String miOperador() {
		return "*";
	}
}