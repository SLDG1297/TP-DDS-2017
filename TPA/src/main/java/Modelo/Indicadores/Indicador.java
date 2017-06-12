package Modelo.Indicadores;

import java.math.BigDecimal;

public class Indicador implements Expresion {

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
}
