package Modelo.Indicadores;

import java.math.BigDecimal;

public class Parentesis extends Expresiones implements Expresion{
    private Expresion expresion;
	
	public Parentesis(Expresiones _expresion) {
		expresion = _expresion;
	}
	
	public BigDecimal calcular(Query query) {
		return expresion.calcular(query);
	}

	public void addOperando(Expresiones operando){
	}

	public String imprimirFormula() {
		return "( " + expresion.imprimirFormula() + " )";
	}
	
	
}
