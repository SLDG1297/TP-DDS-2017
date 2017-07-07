package Modelo.Metodologias.Comparadores;

import java.util.ArrayList;
import java.util.List;

import Modelo.Empresa.BolsaDeEmpresas;
import Modelo.Empresa.Empresa;
import Modelo.Metodologias.Metodologia;
import Modelo.Metodologias.Resultados.Resultado;
import Modelo.Metodologias.Resultados.ResultadoAdapterView;

public class ComparadorMultiple {

	public Empresa empresa;
	public Metodologia metodologia;

	public ComparadorMultiple(Empresa empresa, Metodologia metodologia){
		this.empresa = empresa;
		this.metodologia = metodologia;
	}
	
	public List<ResultadoAdapterView> comparar(){
		List<Empresa> listaEmpresas = BolsaDeEmpresas.getInstancia().getEmpresas();
		List<ResultadoAdapterView> listaResultadosAdapter = new ArrayList<ResultadoAdapterView>();
		for(int i=0; listaEmpresas.size()>i; i++){
			
			Resultado resultado = new ComparadorDual(empresa, listaEmpresas.get(i), metodologia).comparar();
			ResultadoAdapterView resultadoFinal = new ResultadoAdapterView(empresa.getNombre(), listaEmpresas.get(i).getNombre(), resultado.getNombre());
			listaResultadosAdapter.add(resultadoFinal);
		}
		return listaResultadosAdapter;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public Metodologia getMetodologia() {
		return metodologia;
	}
}