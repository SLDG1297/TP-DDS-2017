package Modelo.Indicadores;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import Excepciones.Indicadores.IndicadorSinFormulaException;
import Excepciones.Indicadores.IndicadorSinNombreException;

@Entity
public class Indicador extends Expresiones{

	private String nombre;
	@OneToOne
	private Expresiones formula;

	public Indicador(String nombre, Expresiones formula) {
		this.setNombre(nombre);
		this.setFormula(formula);
	}
	
	public Indicador(){};

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

	public Expresiones getFormula() {
		return formula;
	}

	public void setFormula(Expresiones formula) {
		if(formula == null) throw new IndicadorSinFormulaException();
		this.formula = formula;
	}
	
	public void addOperando(Expresiones operando){
	}
	
	public String imprimirFormula() {
		return "( " + nombre + " = " + formula.imprimirFormula() + " )";
	}

	
	
}
