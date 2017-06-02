package View;

import java.math.BigDecimal;
import org.uqbar.commons.utils.Observable;
import Modelo.CadenaActualDeMiIndicador;
import Modelo.Expresion;
import Modelo.IndicadorBuilder;
import Modelo.Numero;


@Observable
public class VMAgregarNumero {

	IndicadorBuilder miIndicadorBuilder;
	BigDecimal numeroElegido;
	String miCadena = CadenaActualDeMiIndicador.instanciar().mostrarCadenaActual();
	
	public VMAgregarNumero(IndicadorBuilder indicadorBuilder) {
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
