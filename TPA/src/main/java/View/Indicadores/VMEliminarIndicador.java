package View.Indicadores;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import Archivo.Indicadores.AlmacenadorDeIndicadores;
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.IndicadoresRepository;

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
		return IndicadoresRepository.getInstancia().getIndicadores().stream().map(i -> i.getNombre()).collect(Collectors.toList());
	}
	
	public void buscarIndicadorSeleccionado(){
		indicadorSeleccionado = IndicadoresRepository.getInstancia().getIndicador(nombreIndicador);
	}
	
	public void eliminar(Indicador indicador){
		IndicadoresRepository.getInstancia().eliminarIndicador(indicador); 
	}
	
	public void eliminarIndicador(){
		List<Indicador> lista = IndicadoresRepository.getInstancia().getIndicadores();
		for(int i=lista.size()-1; i>=0; i--){
			if (this.contieneIndicador(lista.get(i)) == true){
				this.eliminar(lista.get(i));
			}
		}
		this.eliminar(indicadorSeleccionado);
		try {
			AlmacenadorDeIndicadores.getInstancia().almacenarRepositorioIndicadores();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

public boolean contieneIndicador(Indicador indicador){
		return indicador.mostrarIndicadoresDeFormula().contains(indicadorSeleccionado.getNombre());
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
