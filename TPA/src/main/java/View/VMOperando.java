package View;

import org.uqbar.commons.utils.Observable;
import Modelo.CadenaActualDeMiIndicador;
import Modelo.IndicadorBuilder;

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
		return CadenaActualDeMiIndicador.instanciar().mostrarCadenaActual();
	}
}