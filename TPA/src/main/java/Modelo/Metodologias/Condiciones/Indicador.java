package Modelo.Metodologias.Condiciones;

import Modelo.Indicadores.IndicadoresRepository;

public class Indicador implements Condiciones {

	private Modelo.Indicadores.Indicador indicador;

	public Indicador(Modelo.Indicadores.Indicador indicador) {
		this.indicador = indicador;
	}

	@Override
	public boolean cumple() {
		return IndicadoresRepository.getInstancia().getIndicadores().contains(indicador);
	}
}
