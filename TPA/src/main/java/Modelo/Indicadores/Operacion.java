package Modelo.Indicadores;

import java.math.BigDecimal;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import Modelo.Excepciones.Indicadores.FaltaOperandoDerechoException;

@Entity
@Table(name = "operacion")
public abstract class Operacion extends Expresiones {
	
	//@Column(name = "operacion_valor_a")
	@OneToOne(cascade = {CascadeType.ALL})
	Expresiones valorA;
	
	//@Column(name = "operacion_valor_b")
	@OneToOne(cascade = {CascadeType.ALL})
	Expresiones valorB;
	
	public Operacion(Expresiones valorA) {
	    this.valorA = valorA;
	}
	
	public Operacion(Expresiones valorA, Expresiones valorB){
		this.valorA = valorA;
		this.valorB = valorB;
	}
	
	public Operacion(){};
	
	public BigDecimal calcular(Query query){
		this.puedeRealizarOperacion(query);
		return this.realizarOperacion(query);
	}
	
	public void puedeRealizarOperacion(Query query) {
		if(this.valorB == null) throw new FaltaOperandoDerechoException();
	}
	
	public abstract BigDecimal realizarOperacion(Query query);

	public void addOperando(Expresiones operando){
		  this.valorB = operando;
	}

	protected String imprimirValorB() {
		if(valorB == null)
			return "";		
		
		return valorB.imprimirFormula();
	}
	
	abstract public String miOperador();
		
	public String imprimirFormula() {
		if(valorA == null)
			return "";
		
		return valorA.imprimirFormula() + " " + this.miOperador() + " " + this.imprimirValorB();
	}
	
}
