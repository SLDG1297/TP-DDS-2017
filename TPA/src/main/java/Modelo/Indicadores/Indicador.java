package Modelo.Indicadores;

import java.math.BigDecimal;

import Modelo.Empresa.Deserializable;

public class Indicador implements Expresion, Deserializable{

	private String nombre;
	private Expresion formula;

	public Indicador(String nombre, Expresion formula) {
		this.nombre = nombre;
		this.formula = formula;
	}

	public BigDecimal calcular(Query query) {
		return formula.calcular(query);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Expresion getFormula() {
		return formula;
	}

	public void setFormula(Expresion formula) {
		this.formula = formula;
	}
	
	public void addOperando(Expresion operando){
	}
	
	public String imprimirFormula() {
		return "( " + nombre + " = " + formula.imprimirFormula() + " )";
	}
	
}
