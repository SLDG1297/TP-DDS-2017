package Modelo.Metodologias;

import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.IndicadoresRepository;

public class MetodologiaBuilder {

	String nombreMetodologia;
	Indicador indicadorSeleccionado;
	MetodologiasRepository repositorio = MetodologiasRepository.getInstancia();
	
	public Indicador getIndicadorSeleccionado() {
		return indicadorSeleccionado;
	}

	public void setIndicadorSeleccionado(Indicador indicadorSeleccionado) {
		this.indicadorSeleccionado = indicadorSeleccionado;
	}

	public String getNombreMetodologia() {
		return nombreMetodologia;
	}

	public void setNombreMetodologia(String nombreMetodologia) {
		this.nombreMetodologia = nombreMetodologia;
	}

	//TODO
	public void crearMetodologia(){ 
		//this.repositorio.agregarMetodologia(new Metodologia(nombreIndicador,expresion));
	}
}
