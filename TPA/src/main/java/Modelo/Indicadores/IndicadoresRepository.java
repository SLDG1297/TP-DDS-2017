package Modelo.Indicadores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Exepciones.Indicadores.NoHayIndicadoresEnElRepositorioException;
import Exepciones.Indicadores.NombreIndicadorErroneoException;

public class IndicadoresRepository {

	private static IndicadoresRepository instancia = null;

	private List<Indicador> indicadores = new ArrayList<Indicador>();

	public List<Indicador> getIndicadores() {
		if(indicadores.size() == 0) throw new NoHayIndicadoresEnElRepositorioException();
		return indicadores;
	}
	
	public void setIndicadores(List<Indicador> unosIndicadores){
		this.indicadores = unosIndicadores;
	}

	public Indicador getIndicador(String nombre) {
		return indicadores.stream().filter(i -> i.getNombre().equals(nombre)).findFirst().orElseThrow(() -> new NombreIndicadorErroneoException());
	}
	
	public List<String> obtenerNombreDeTodosLosIndicadores(){
	return this.indicadores.stream().map(i -> i.getNombre()).collect(Collectors.toList());
	}
	public void agregarIndicador(Indicador indicador) {
		indicadores.add(indicador);
	}
	
	public void agregarIndicadores(List<Indicador> unosIndicadores){
		indicadores.addAll(unosIndicadores);
	}
	

	public void eliminarIndicador(Indicador indicador) {
		indicadores.remove(indicador);
	}

	public static IndicadoresRepository getInstancia() {

		if (instancia == null) {
		instancia = new IndicadoresRepository();
		}
		return instancia;
	}

	public static void setInstancia(IndicadoresRepository instancia) {
		IndicadoresRepository.instancia = instancia;
	}
}
