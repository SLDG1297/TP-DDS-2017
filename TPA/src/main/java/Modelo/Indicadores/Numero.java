package Modelo.Indicadores;

import java.math.BigDecimal;
import javax.persistence.Entity;

@Entity
public class Numero extends Expresiones{
	private BigDecimal numero;
	
	public Numero(BigDecimal num){
		this.numero = num;
	}
	
	public Numero(){};

	public BigDecimal calcular(Query query) {
		return numero;
	}
	
	public void addOperando(Expresiones operando){
	}
	
	public String imprimirFormula() {
		return numero.toString();
	}

}
