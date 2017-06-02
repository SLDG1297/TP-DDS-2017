package View;

import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import Modelo.CadenaActualDeMiIndicador;
import Modelo.IndicadoresRepository;

@Observable
public class VMIndicadorCreado {
	public List<String> nombresDeIndicadoresExistentes;

	public VMIndicadorCreado() {

		nombresDeIndicadoresExistentes = IndicadoresRepository.getInstancia().getIndicadores().stream().map(i -> i.getNombre()).collect(Collectors.toList());

	}

	public List<String> getNombresDeIndicadoresExistentes() {
		return nombresDeIndicadoresExistentes;
	}

	public void setNombresDeIndicadoresExistentes(List<String> nombresDeIndicadoresExistentes) {
		this.nombresDeIndicadoresExistentes = nombresDeIndicadoresExistentes;
	}
	
	public String getMiCadena() {
		return CadenaActualDeMiIndicador.instanciar().mostrarCadenaActual();
	}
}