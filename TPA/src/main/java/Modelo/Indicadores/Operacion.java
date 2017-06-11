package Modelo.Indicadores;

import java.math.BigDecimal;

import Exepciones.FaltaOperandoDerechoException;

public abstract class Operacion extends Expresion {
	Expresion valorA, valorB;
	
	public Operacion(Expresion valorA) {
	    this.valorA = valorA;
	}
	
	public Operacion(Expresion valorA, Expresion valorB){
		this.valorA = valorA;
		this.valorB = valorB;
	}
	
	public abstract BigDecimal calcular(Query query);
	
	protected void sePuedeCalcular(){
		if(valorB == null)
			throw new FaltaOperandoDerechoException();
	}
	
	public void addOperando(Expresion operando){
		  this.valorB = operando;
	}
	
}
