package View.Indicadores;

import java.math.BigDecimal;
import org.uqbar.commons.utils.Observable;
import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.IndicadorBuilder;
import Modelo.Indicadores.Numero;


@Observable
public class VMAgregarNumero extends VMAgregar {

	IndicadorBuilder miIndicadorBuilder;
	BigDecimal numeroElegido;
	public String miCadena = miIndicadorBuilder.imprimirFormula();
	
	public VMAgregarNumero(IndicadorBuilder indicadorBuilder) {
		super(indicadorBuilder);
		miIndicadorBuilder = indicadorBuilder;
	}
		
		
	public void setMiIndicadorBuilder(IndicadorBuilder miIndicadorBuilder) {
		this.miIndicadorBuilder = miIndicadorBuilder;
	}


	public IndicadorBuilder getMiIndicadorBuilder() {
		return miIndicadorBuilder;
	}
	
	public BigDecimal getNumeroElegido() {
		return numeroElegido;
	}


	public void setNumeroElegido(BigDecimal numeroElegido) {
		this.numeroElegido = numeroElegido;
	}
	
	public Expresion devolverNumero() {
		
		return new Numero(numeroElegido);
		
	}
	
	public String devolverStringDeNumero() {
		
		return numeroElegido.toString();
		
	}
	
	
	public String getMiCadena() {
		return miCadena;
	}

	public void setMiCadena(String miCadena) {
		this.miCadena = miCadena;
	}
	


}
