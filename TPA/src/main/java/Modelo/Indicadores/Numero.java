package Modelo.Indicadores;

import java.math.BigDecimal;

import Modelo.Empresa.Deserializable;

public class Numero implements Expresion, Deserializable{
	private BigDecimal numero;
	
	public Numero(BigDecimal num){
		this.numero = num;
	}

	public BigDecimal calcular(Query query) {
		return numero;
	}
	
	public void addOperando(Expresion operando){
	}
	
	public String imprimirFormula() {
		return numero.toString();
	}

}
