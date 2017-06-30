package Modelo.Metodologias;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.Query;

public abstract class Condicion implements Condiciones{

	private Indicador indicador;
	private Empresa empresa;

	
	public Condicion(Indicador indicador, Empresa empresa) {
		this.indicador = indicador;
		this.empresa = empresa;
	}
	
	public boolean cumple(){
		List<Periodo> listaPeriodos = this.inicio(empresa.getPeriodos());
		List<Try> listaSuccess = this.cuerpo(listaPeriodos);
		return fin(listaSuccess);
	}
	
	public abstract List<Periodo> inicio(List<Periodo> lista);
	
	public List<Try> cuerpo(List<Periodo> lista){
		return lista.stream()
		.map(periodo -> Try.ofFailable(() -> indicador.evaluar(new Query(empresa,periodo.getAnio()))))
	    .filter(evaluacion -> evaluacion.isSuccess()).collect(Collectors.toList());
	}
	
	public abstract boolean fin(List<Try> success);

	
}
