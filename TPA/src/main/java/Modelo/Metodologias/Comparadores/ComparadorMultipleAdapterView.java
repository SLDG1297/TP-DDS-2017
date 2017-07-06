package Modelo.Metodologias.Comparadores;

import java.util.ArrayList;
import java.util.List;

import Modelo.Metodologias.Resultados.Resultado;

public class ComparadorMultipleAdapterView {
	
	private ComparadorMultiple comparador;
	private List<Resultado> listaResultados = new ArrayList<Resultado>();
	
	
	public ComparadorMultipleAdapterView(ComparadorMultiple comparador){
		this.comparador = comparador;
		listaResultados = comparador.comparar();
	}

	public List<Resultado> getListaResultados() {
		return listaResultados;
	}
	
}
