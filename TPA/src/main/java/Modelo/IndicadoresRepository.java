package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IndicadoresRepository {
	
	private static IndicadoresRepository instancia = null;
	
	private List<Indicador> indicadores = new ArrayList<Indicador>();
	
	/*//Puede ser que no sirva
	public boolean existeIndicador(String nombre){
		return indicadores.stream().map(i -> i.getNombre()).collect(Collectors.toList()).contains(nombre);
	}
	*/
	public Indicador getIndicador(String nombre){
		return instancia.indicadores.stream().filter(i -> i.getNombre().equals(nombre)).findFirst().get();
	}
	
	public void agregarIndicador(Indicador indicador){
		instancia.indicadores.add(indicador);
	}

	public static IndicadoresRepository getInstancia() {
		
		if(instancia == null){
			instancia = new IndicadoresRepository();
		}
		
		return instancia;
	}
}
