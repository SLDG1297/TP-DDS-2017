package Modelo.Indicadores;

import java.math.BigDecimal;

public class Numero extends Expresion{
	private BigDecimal numero;
	
	public Numero(BigDecimal num){
		this.numero = num;
	}

	public BigDecimal calcular(Query query) {
		return numero;
	}

}
