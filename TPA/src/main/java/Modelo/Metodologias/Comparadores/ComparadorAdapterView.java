package Modelo.Metodologias.Comparadores;

import java.util.ArrayList;
import java.util.List;

import Modelo.Empresa.BolsaDeEmpresas;
import Modelo.Empresa.Empresa;
import Modelo.Metodologias.Metodologia;
import Modelo.Metodologias.MetodologiasRepository;
import Modelo.Metodologias.Resultados.Resultado;

public class ComparadorAdapterView {
	
	List<Resultado> listaResultados = new ArrayList<Resultado>();
	List<String> listaEmpresas = new ArrayList<String>(); //Soluciona lo que hablamos con gonza
	List<String> listaDeEmpresaConElMismoNombre = new ArrayList<String>(); //Es para que en la tabla se muestre la empresa1 tambien, porfa no lo borres y bindialo a una columna
	
	//Constructor para usar ComparadorMultiple
	public ComparadorAdapterView(ComparadorMultiple comparador){
		listaResultados = comparador.comparar();
		listaEmpresas = BolsaDeEmpresas.getInstancia().getNombresDeEmpresas();
		this.getlistaDeEmpresaConElMismoNombre(listaResultados.size(), comparador); 
	}
	
	private List<String> getlistaDeEmpresaConElMismoNombre (int tamanio, ComparadorMultiple comparador){
		List<String> listaDeEmpresaConElMismoNombre = new ArrayList<String>();
		for (int i=0; tamanio>i; i++){
			listaDeEmpresaConElMismoNombre.add(comparador.getEmpresa().getNombre());
		}
		return listaDeEmpresaConElMismoNombre;
	}
	
	public List<Resultado> getListaResultados() {
		return listaResultados;
	}
	
	
}
