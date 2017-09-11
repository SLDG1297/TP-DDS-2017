package Modelo.Indicadores;

import java.math.BigDecimal;

import Excepciones.Indicadores.IndicadorSinFormulaException;
import Excepciones.Indicadores.IndicadorSinNombreException;
import Modelo.Empresa.Deserializa;

public class Indicador implements Expresion, Deserializa{

	private String nombre;
	private Expresion formula;

	public Indicador(String nombre, Expresion formula) {
		this.setNombre(nombre);
		this.setFormula(formula);
	}

	public BigDecimal calcular(Query query) {
		return formula.calcular(query);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == "") throw new IndicadorSinNombreException();
		this.nombre = nombre;
	}

	public Expresion getFormula() {
		return formula;
	}

	public void setFormula(Expresion formula) {
		if(formula == null) throw new IndicadorSinFormulaException();
		this.formula = formula;
	}
	
	public void addOperando(Expresion operando){
	}
	
	public String imprimirFormula() {
		return "( " + nombre + " = " + formula.imprimirFormula() + " )";
	}
	
}
