package Modelo.Indicadores;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

import Excepciones.Indicadores.NoSePuedeDividirPorCeroException;
@Entity
@Table(name = "division")
public class Division extends Operacion {

	public Division(Expresiones valorA) {
		super(valorA);
	}

	public Division(Expresiones valorA, Expresiones valorB) {
		super(valorA, valorB);
	}
	
	@Override
	public void puedeRealizarOperacion(Query query){
		super.puedeRealizarOperacion(query);
		if(this.valorB.calcular(query).equals(new BigDecimal(0))) throw new NoSePuedeDividirPorCeroException();
	}

	@Override
	public BigDecimal realizarOperacion(Query query) {
		return this.valorA.calcular(query).divide(this.valorB.calcular(query), BigDecimal.ROUND_FLOOR);
	}

	public String miOperador() {
		return "/";
	}
}
