package Modelo.Indicadores;

import java.math.BigDecimal;

public class Numero implements Expresion{
	private BigDecimal numero;
	
	public Numero(BigDecimal num){
		this.numero = num;
	}

	public BigDecimal calcular(Query query) {
		return numero;
	}
	
	public void addOperando(Expresion operando){
	}
	
	public String nombre(){
		return "";
	}

}
