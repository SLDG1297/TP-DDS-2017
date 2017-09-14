package View.Indicadores;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.uqbar.commons.utils.Observable;

import Archivo.EscritorDeAchivos;
import Archivo.SerializadorJson;
import DB.Repositorios.IndicadoresRepository;
import Modelo.Indicadores.Indicador;

@Observable
public class VMEliminarIndicador {

	public String nombreIndicador;
	public List<String> listaDeNombresDeIndicador;
	//Indicador seleccionado
	Indicador indicadorSeleccionado;
	
	public VMEliminarIndicador() {
		super();
		listaDeNombresDeIndicador = this.buscarNombresDeIndicadores();
	}
	
	private List<String> buscarNombresDeIndicadores() {
		return IndicadoresRepository.getInstancia().getNombresIndicadores();
	}
	
	public void buscarIndicadorSeleccionado(){
		indicadorSeleccionado = IndicadoresRepository.getInstancia().getIndicador(nombreIndicador);
	}
	
	public void eliminar(Indicador indicador){
		IndicadoresRepository.getInstancia().eliminarIndicador(indicador); 
	}
	
	public void eliminarIndicador(){
		IndicadoresRepository.getInstancia().eliminarIndicador(indicadorSeleccionado);
	}

	public String getNombreIndicador() {
		return nombreIndicador;
	}

	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
	}

	public List<String> getListaDeNombresDeIndicador() {
		return listaDeNombresDeIndicador;
	}

	public void setListaDeNombresDeIndicador(List<String> listaDeNombresDeIndicador) {
		this.listaDeNombresDeIndicador = listaDeNombresDeIndicador;
	}

	public Indicador getIndicadorSeleccionado() {
		return indicadorSeleccionado;
	}

	public void setIndicadorSeleccionado(Indicador indicadorSeleccionado) {
		this.indicadorSeleccionado = indicadorSeleccionado;
	}

}
