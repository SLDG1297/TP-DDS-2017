package Modelo.Indicadores;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("gdfgSuma")
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
