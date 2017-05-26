package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IndicadoresRepository {

	private List<Indicador> indicadores = new ArrayList<Indicador>();
	
	public boolean existeIndicador(String nombre){
		return indicadores.stream().map(i -> i.getNombre()).collect(Collectors.toList()).contains(nombre);
	}
	
	public Indicador getIndicador(String nombre){
		return indicadores.stream().filter(i -> i.getNombre().equals(nombre)).findFirst().get();
	}
	
}
