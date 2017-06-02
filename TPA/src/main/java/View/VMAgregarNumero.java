package View;

import java.math.BigDecimal;

import org.uqbar.commons.utils.Observable;

import Modelo.CadenaActualDeMiIndicador;
import Modelo.Expresion;
import Modelo.Indicador;
import Modelo.IndicadorBuilder;
import Modelo.IndicadoresRepository;
import Modelo.Numero;


@Observable
public class VMAgregarNumero {

	IndicadorBuilder miIndicadorBuilder;
	BigDecimal numeroElegido;
	
	
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
		
		Numero numero;
		numero = new Numero(numeroElegido);
		return numero;
		
	}
	
	public String getMiCadena() {
		return CadenaActualDeMiIndicador.instanciar().mostrarCadenaActual();
	}


}
