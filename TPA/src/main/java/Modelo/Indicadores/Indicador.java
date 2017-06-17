package Modelo.Indicadores;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
	
	public void addOperando(Expresion operando){
		/*this.formula = operando;*/
	}
	
	public String nombre(){
		return getNombre();
	}
	
	public List<String> mostrarIndicadoresDeFormula(){
		List<String> lista = new ArrayList<String>();
		lista.add(this.nombre());
		if (!formula.nombre().equals("")){
		lista.add(formula.nombre());
		}
		return lista;
	}
}
