package View.Metodologias;

import java.util.ArrayList;
import java.util.List;
import org.uqbar.commons.utils.Observable;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Metodologia;
import Modelo.Metodologias.MetodologiaBuilder;
import Modelo.Metodologias.Condiciones.CasiSiempreCreciente;
import Modelo.Metodologias.Condiciones.CasiSiempreDecreciente;
import Modelo.Metodologias.Condiciones.Condicion;
import Modelo.Metodologias.Condiciones.SiempreCreciente;
import Modelo.Metodologias.Condiciones.SiempreDecreciente;

@Observable
public class VMAgregarComportamiento {

	private String comportamientoElegido;
	public String getComportamientoElegido() {
		return comportamientoElegido;
	}

	public void setComportamientoElegido(String comportamientoElegido) {
		this.comportamientoElegido = comportamientoElegido;
	}

	public List<String> getComportamientos() {
		return comportamientos;
	}

	public void setComportamientos(List<String> comportamientos) {
		this.comportamientos = comportamientos;
	}

	private List<String> comportamientos = new ArrayList<String>();
	private Integer periodoElegido;
	private MetodologiaBuilder miMetodologiaBuilder;
	
	public VMAgregarComportamiento(MetodologiaBuilder _miMetodologiaBuilder){
		super();
		miMetodologiaBuilder = _miMetodologiaBuilder;
		comportamientos.add("Siempre creciente");
		comportamientos.add("Casi siempre creciente");
		comportamientos.add("Siempre decreciente");
		comportamientos.add("Casi siempre decreciente");
	}
	
    public Integer getPeriodoElegido() {
		return periodoElegido;
	}

	public void setPeriodoElegido(Integer periodoElegido) {
		this.periodoElegido = periodoElegido;
	}

	public MetodologiaBuilder getMiMetodologiaBuilder() {
		return miMetodologiaBuilder;
	}

	public void setMiMetodologiaBuilder(MetodologiaBuilder miMetodologiaBuilder) {
		this.miMetodologiaBuilder = miMetodologiaBuilder;
	}

	public void crearCondicion(){
    	
    	Indicador indicadorSeleccionado = miMetodologiaBuilder.getIndicadorSeleccionado();
    	Condicion nuevaCondicion;
    	
    	switch(comportamientoElegido) {
    	
    	case "Siempre creciente":
    		nuevaCondicion = new SiempreCreciente(indicadorSeleccionado,periodoElegido);
    		break;
    		
    	case "Casi siempre creciente":
    		nuevaCondicion = new CasiSiempreCreciente(indicadorSeleccionado,periodoElegido);
    		break;
    	
    	case "Siempre decreciente":
    		nuevaCondicion = new SiempreDecreciente(indicadorSeleccionado,periodoElegido);
    		break;
    		
    	default:
    		nuevaCondicion = new CasiSiempreDecreciente(indicadorSeleccionado,periodoElegido);
    		break;
    	}
    	 	
    	/*
    	if(comportamientoElegido.equals("Siempre creciente")){
    		nuevaCondicion = new SiempreCreciente(indicadorSeleccionado,periodoElegido);
    	}
    	
    	if(comportamientoElegido.equals("Casi siempre creciente")){
    		nuevaCondicion = new CasiSiempreCreciente(indicadorSeleccionado,periodoElegido);
    	}
    	
    	if(comportamientoElegido.equals("Siempre decreciente")){
    		nuevaCondicion = new SiempreDecreciente(indicadorSeleccionado,periodoElegido);
    	}
    	
    	else{
    		nuevaCondicion = new CasiSiempreDecreciente(indicadorSeleccionado,periodoElegido);
    	}
    	*/
    	
    	miMetodologiaBuilder.agregarCondicion(nuevaCondicion);
    }

	public Metodologia crearMetodologia() {
		return miMetodologiaBuilder.crearMetodologia();
	}
	
}
