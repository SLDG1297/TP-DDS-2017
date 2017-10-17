package Modelo.Indicadores;

import java.math.BigDecimal;

import javax.persistence.*;

import DB.Converter.IndicadorConverter;
import DB.TipoDeRepositorio;
import Modelo.Excepciones.Indicadores.IndicadorSinFormulaException;
import Modelo.Excepciones.Indicadores.IndicadorSinNombreException;

@Entity
@Table(name = "indicador")
public class Indicador implements Expresion, TipoDeRepositorio {
	@Id
	@GeneratedValue
	@Column(name = "indicador_id")
	private long id;
	
	@Column(name = "indicador_nombre")
	private String nombre;

	@Column(name = "indicador_formula", columnDefinition = "LONGTEXT")
	@Convert(converter = IndicadorConverter.class)
	private Expresion formula;

	public Indicador(String nombre, Expresion formula) {
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
