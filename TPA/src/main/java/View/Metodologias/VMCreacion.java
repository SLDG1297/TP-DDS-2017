package View.Metodologias;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.IndicadoresRepository;

@Observable
public class VMCreacion {

	private String nombreMetodologia;
	public String nombreDeIndicadorElegido;
	private List<String> nombresDeIndicadoresExistentes;
	
	public VMCreacion(){
		super();
		setNombresDeIndicadoresExistentes(IndicadoresRepository.getInstancia().getNombresIndicadores());
	}

	public String getNombreDeIndicadorElegido() {
		return nombreDeIndicadorElegido;
	}

	public void setNombreDeIndicadorElegido(String nombreDeIndicadorElegido) {
		this.nombreDeIndicadorElegido = nombreDeIndicadorElegido;
	}

	public String getNombreMetodologia() {
		return nombreMetodologia;
	}

	public void setNombreMetodologia(String nombreMetodologia) {
		this.nombreMetodologia = nombreMetodologia;
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
