package View.Indicadores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
			if (this.contieneIndicador(lista.get(i)) == true){ //Le pregunta a cada indicador del repositorio si tiene en su formula o si es el indicador a eliminar
				this.eliminar(lista.get(i));
			}
		}
		try {
			AlmacenadorDeIndicadores.getInstancia().almacenarRepositorioIndicadores(); //Actualiza el estado de los nuevos indicadores 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*Collections.reverse(lista);
		for (Indicador indicador : lista){
			if (this.contieneIndicador(indicador) == true){	
				this.eliminar(indicador);
			}
		}*/
	}

public boolean contieneIndicador(Indicador indicador){
		return this.mostrarIndicadoresDeFormula(indicador).contains(indicadorSeleccionado.getNombre());
	}

public List<String> mostrarIndicadoresDeFormula(Indicador indicador){
		String[] array = indicador.imprimirFormula().split(","); //Separa toma cada nombre de indicador que esta separado por una coma y una guarda en un array
		return Arrays.asList(array); //transforma el array en un lista
		
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
