package Modelo.Metodologias.Condiciones;

import Modelo.Empresa.Deserializable;
import Modelo.Empresa.Empresa;
import Modelo.Indicadores.IndicadoresRepository;

public class Indicador implements Condiciones, Deserializable{

	private Modelo.Indicadores.Indicador indicador;

	public Indicador(Modelo.Indicadores.Indicador indicador) {
		this.indicador = indicador;
	}

	@Override
	public boolean cumple(Empresa empresa) {
		return IndicadoresRepository.getInstancia().getIndicadores().contains(indicador);
	}
	
	@Override
	public String mostrarCadena() {
		return "El indicador " + indicador.getNombre() + " ???";
	}
}