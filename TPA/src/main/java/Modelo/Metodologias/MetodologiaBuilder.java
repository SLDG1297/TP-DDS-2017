package Modelo.Metodologias;

import java.util.ArrayList;
import java.util.List;

import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Condiciones.Condicion;
import Modelo.Metodologias.Condiciones.Condiciones;

public class MetodologiaBuilder {

	private String nombreMetodologia;
	private Indicador indicadorSeleccionado;
	public List<Condiciones> getCondiciones() {
		return condiciones;
	}

	public void setCondiciones(List<Condiciones> condiciones) {
		this.condiciones = condiciones;
	}

	private MetodologiasRepository repositorio = MetodologiasRepository.getInstancia();
	private List<Condiciones> condiciones = new ArrayList<Condiciones>();
	
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
	
	public void agregarCondicion(Condicion c){
		condiciones.add(c);
	}
	
	public void crearMetodologia(){ 
	repositorio.agregarMetodologia(new Metodologia(nombreMetodologia,condiciones));
	}
}
