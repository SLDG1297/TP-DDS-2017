package Modelo.Indicadores;

import java.math.BigDecimal;

import Excepciones.Indicadores.FaltaOperandoDerechoException;
import Modelo.Empresa.Deserializable;

public abstract class Operacion implements Expresion, Deserializable {
	Expresion valorA, valorB;
	
	public Operacion(Expresion valorA) {
	    this.valorA = valorA;
	}
	
	public Operacion(Expresion valorA, Expresion valorB){
		this.valorA = valorA;
		this.valorB = valorB;
	}
	
	public BigDecimal calcular(Query query){
		this.sePuedeCalcular();
		return this.realizarOperacion(query);
	}
	
	public abstract BigDecimal realizarOperacion(Query query);
	
	protected void sePuedeCalcular(){
		if(valorB == null)
			throw new FaltaOperandoDerechoException();
	}
	
	public void addOperando(Expresion operando){
		  this.valorB = operando;
	}
	
	public String imprimirFormulaindicador(){
		return "";
	}
}
