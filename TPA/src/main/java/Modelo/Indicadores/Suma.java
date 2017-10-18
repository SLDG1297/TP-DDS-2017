package Modelo.Indicadores;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "suma")
public class Suma extends Operacion {

	public Suma(Expresiones valorA) {
		super(valorA);
	}
	
	public Suma(Expresiones valorA, Expresiones valorB) {
		super(valorA, valorB);
	}
	
	public Suma(){};
	
	@Override
	public BigDecimal realizarOperacion(Query query) {
		return this.valorA.calcular(query).add(this.valorB.calcular(query));
	}
	
	public String miOperador() {
		return "+";
	}
}
