package Modelo.Indicadores;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import Excepciones.Indicadores.FaltaOperandoDerechoException;

@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorValue( "null" )
public abstract class Operacion extends Expresiones {
	@OneToOne
	Expresiones valorA;
	@OneToOne
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
