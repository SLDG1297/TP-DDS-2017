
package View.Indicadores;

import org.uqbar.commons.utils.Observable;
import Modelo.Indicadores.IndicadorBuilder;

@Observable
public class VMOperando {

IndicadorBuilder miIndicadorBuilder;

	public VMOperando(IndicadorBuilder indicadorBuilder) {
		super();
		this.miIndicadorBuilder = indicadorBuilder;
		
	}

	public IndicadorBuilder getMiIndicadorBuilder() {
		return miIndicadorBuilder;
	}

	public void setMiIndicadorBuilder(IndicadorBuilder miIndicadorBuilder) {
		this.miIndicadorBuilder = miIndicadorBuilder;
	}
	
	public String getMiCadena() {
		return miIndicadorBuilder.imprimirFormula();
	}
}