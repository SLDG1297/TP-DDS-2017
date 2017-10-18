package Modelo.Indicadores;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "numero")
public class Numero extends Expresiones{
	
	@Column(name="numero_valor")
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
