package Modelo.Metodologias;

import java.util.ArrayList;
import java.util.List;

import Modelo.Empresa.BolsaDeEmpresas;
import Modelo.Empresa.Empresa;

public class ComparadorMultiple {

	private Empresa empresa;
	private Metodologia metodologia;

	public ComparadorMultiple(Empresa empresa, Metodologia metodologia){
		this.empresa = empresa;
		this.metodologia = metodologia;
	}
	
	public List<Resultado> comparar(){
		List<Empresa> listaEmpresas = BolsaDeEmpresas.getInstancia().getEmpresas();
		List<Resultado> listaResultados = new ArrayList<Resultado>();
		for(int i=0; listaEmpresas.size()>i; i++){
			listaResultados.add(new ComparadorDual(empresa, listaEmpresas.get(i), metodologia).comparar());
		}
		return listaResultados;
	}
}
