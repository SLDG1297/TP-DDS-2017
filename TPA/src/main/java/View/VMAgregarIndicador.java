package View;

import java.util.List;

import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;
import Modelo.CadenaActualDeMiIndicador;
import Modelo.Indicador;
import Modelo.IndicadorBuilder;
import Modelo.IndicadoresRepository;

@Observable
public class VMAgregarIndicador {
 
	public String nombreDeIndicadorElegido;
	public List<String> nombresDeIndicadoresExistentes;
	public IndicadorBuilder miIndicadorBuilder;
	
	//Constructor
	public VMAgregarIndicador(IndicadorBuilder indicadorBuilder) {
		super();	
		miIndicadorBuilder = indicadorBuilder;
		nombresDeIndicadoresExistentes = IndicadoresRepository.getInstancia().getIndicadores().stream().map(i -> i.getNombre()).collect(Collectors.toList());
	}

	public IndicadorBuilder getMiIndicadorBuilder() {
		return miIndicadorBuilder;
	}

	public void setMiIndicadorBuilder(IndicadorBuilder miIndicadorBuilder) {
		this.miIndicadorBuilder = miIndicadorBuilder;
	}

	public String getNombreDeIndicadorElegido() {
		return nombreDeIndicadorElegido;
	}

	public void setNombreDeIndicadorElegido(String nombreDeIndicadorElegido) {
		this.nombreDeIndicadorElegido = nombreDeIndicadorElegido;
	}
	
	public String getMiCadena() {
		return CadenaActualDeMiIndicador.instanciar().mostrarCadenaActual();
	}

	public List<String> getNombresDeIndicadoresExistentes() {
		return nombresDeIndicadoresExistentes;
	}

	public void setNombresDeIndicadoresExistentes(List<String> nombresDeIndicadoresExistentes) {
		this.nombresDeIndicadoresExistentes = nombresDeIndicadoresExistentes;
	}
	
	public Indicador devolverIndicador() {
		return IndicadoresRepository.getInstancia().getIndicador(nombreDeIndicadorElegido);	
	}
	
}