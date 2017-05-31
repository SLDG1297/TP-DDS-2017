package Modelo;

import java.math.BigDecimal;
import java.util.List;

public class Indicador implements Expresion {

	private String nombre;
	private Expresion formula;
	
	public Indicador(String nombre, Expresion formula) {
		this.nombre = nombre;
		this.formula = formula;
	}
		
	public BigDecimal calcular(Query query){
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
