package Modelo.Metodologias.Comparadores;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public ComparadorMultiple(Metodologia metodologia){
		
		this.metodologia = metodologia;
	}
	
	public List<ResultadoAdapterView> comparar(){
		List<Empresa> listaEmpresas = BolsaDeEmpresas.getInstancia().getEmpresas();
		return listaEmpresas.stream().map(emp -> generarResultadoViewAdapter(emp)).collect(Collectors.toList());
		
		/*List<ResultadoAdapterView> listaResultadosAdapter = new ArrayList<ResultadoAdapterView>();
		for(Empresa e :listaEmpresas){
			
			Resultado resultado = new ComparadorDual(empresa, e, metodologia).comparar();
			ResultadoAdapterView resultadoFinal = new ResultadoAdapterView(empresa.getNombre(), e.getNombre(), resultado.getNombre());
			listaResultadosAdapter.add(resultadoFinal);
		}
		return listaResultadosAdapter;*/
		
	}

	private ResultadoAdapterView generarResultadoViewAdapter(Empresa emp) {
		return new ResultadoAdapterView(empresa.getNombre(),emp.getNombre(),generarResultadoDual(emp).getNombre());
	}

	private Resultado generarResultadoDual(Empresa emp) {
		return new ComparadorDual(empresa, emp, metodologia).comparar();
	}
	
	public List<ResultadoAdapterView> compararTodosconTodo(){
		List<Empresa> listaEmpresas = BolsaDeEmpresas.getInstancia().getEmpresas();
		return listaEmpresas.stream().map(emp -> new ResultadoAdapterView(emp.getNombre(), metodologia, generarResultadoUnario(emp))).collect(Collectors.toList());
		
		/*List<ResultadoAdapterView> listaResultadosAdapter = new ArrayList<ResultadoAdapterView>();
		for(int i=0; listaEmpresas.size()>i; i++){
			
			boolean resultado = new ComparadorUnario(listaEmpresas.get(i),metodologia).evaluar();
			ResultadoAdapterView resultadoFinal = new ResultadoAdapterView(listaEmpresas.get(i).getNombre(),metodologia, resultado);
			listaResultadosAdapter.add(resultadoFinal);
		}
		return listaResultadosAdapter;*/

	}

	private boolean generarResultadoUnario(Empresa emp) {
		return new ComparadorUnario(emp,metodologia).evaluar();
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public Metodologia getMetodologia() {
		return metodologia;
	}
}