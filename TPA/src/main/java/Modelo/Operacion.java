package Modelo;

import java.math.BigDecimal;

public abstract class Operacion implements Expresion {
	Operacion valorA, valorB;
	
	public Operacion(Operacion valorA) {
	    this.valorA = valorA;
	}
	
	public abstract BigDecimal calcular(Query query);
	
	public void addOperando(Operacion operando){
		  this.valorB = operando;
	}
	
}
