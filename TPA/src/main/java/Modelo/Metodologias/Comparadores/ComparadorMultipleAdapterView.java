package Modelo.Metodologias.Comparadores;

import java.util.ArrayList;
import java.util.List;

import Modelo.Empresa.BolsaDeEmpresas;
import Modelo.Empresa.Empresa;
import Modelo.Metodologias.Metodologia;
import Modelo.Metodologias.MetodologiasRepository;
import Modelo.Metodologias.Resultados.Resultado;

public class ComparadorMultipleAdapterView {
	
	private ComparadorMultiple comparador;
	List<Resultado> listaResultados = new ArrayList<Resultado>();
	List<Empresa> listaEmpresas = new ArrayList<Empresa>(); //Soluciona lo que hablamos con gonza
	
	
	public ComparadorMultipleAdapterView(ComparadorMultiple comparador){
		this.comparador = comparador;
		listaResultados = comparador.comparar();
		listaEmpresas = BolsaDeEmpresas.getInstancia().getEmpresas();
	}

	public List<Resultado> getListaResultados() {
		return listaResultados;
	}
	
}
