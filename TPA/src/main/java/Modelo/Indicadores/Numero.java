package Modelo.Indicadores;

import java.math.BigDecimal;

public class Numero implements Expresion{
	private BigDecimal numero;
	private Expresion a;
	
	public Numero(BigDecimal num){
		this.numero = num;
	}

	public BigDecimal calcular(Query query) {
		return numero;
	}
	
	public void addOperando(Expresion operando){
		/*this.a = operando;*/
	}

}
