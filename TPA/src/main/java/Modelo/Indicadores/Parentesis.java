package Modelo.Indicadores;

import java.math.BigDecimal;

public class Parentesis extends Expresion{
    private Expresion expresion;
	
	public Parentesis(Expresion _expresion) {
		expresion = _expresion;
	}
	
	public BigDecimal calcular(Query query) {
		return expresion.calcular(query);
	}

	public void addOperando(Expresion operando){
		/*expresion = operando;*/
	}
}
