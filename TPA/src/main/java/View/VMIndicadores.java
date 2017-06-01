package View;

import org.uqbar.commons.utils.Observable;

import Indicadores.IndicadoresRepository;

@Observable
public class VMIndicadores {
	IndicadoresRepository misIndicadores;
	
	public VMIndicadores(IndicadoresRepository indicadores) {
		misIndicadores = indicadores;
	}
}
