package View.Indicadores;

import java.util.List;
import org.uqbar.commons.utils.Observable;

import DB.Repositorios.RepositorioIndicadores;
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
		return RepositorioIndicadores.getInstancia().darListaNombres();
	}
	
	public void buscarIndicadorSeleccionado(){
		indicadorSeleccionado = RepositorioIndicadores.getInstancia().buscarObjeto(nombreIndicador);
	}
	
	public void eliminar(Indicador indicador){
		RepositorioIndicadores.getInstancia().eliminarObjeto(indicador); 
	}
	
	public void eliminarIndicador(){
		RepositorioIndicadores.getInstancia().eliminarObjeto(indicadorSeleccionado);
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
