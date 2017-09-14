package View.Indicadores;

import java.util.List;
import java.util.stream.Collectors;
import org.uqbar.commons.utils.Observable;

import DB.Repositorios.IndicadoresRepository;
import Modelo.Indicadores.Indicador;

@Observable
public class VMIndicadorCreado {
	public List<String> nombresDeIndicadoresExistentes;
	private Indicador indicadorCreado;

	public VMIndicadorCreado(Indicador indicadorNuevo) {

		nombresDeIndicadoresExistentes = IndicadoresRepository.getInstancia().getIndicadores().stream().map(i -> i.getNombre()).collect(Collectors.toList());

		indicadorCreado = indicadorNuevo;
		
	}

	public List<String> getNombresDeIndicadoresExistentes() {
		return nombresDeIndicadoresExistentes;
	}

	public void setNombresDeIndicadoresExistentes(List<String> nombresDeIndicadoresExistentes) {
		this.nombresDeIndicadoresExistentes = nombresDeIndicadoresExistentes;
	}
	
	public String getMiCadena() {
		return indicadorCreado.imprimirFormula();
	}
}