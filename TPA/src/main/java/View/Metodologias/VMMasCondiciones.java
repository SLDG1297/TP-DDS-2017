package View.Metodologias;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.IndicadoresRepository;
import Modelo.Metodologias.MetodologiaBuilder;

@Observable
public class VMMasCondiciones {

	private MetodologiaBuilder miMetodologiaBuilder;
	public String nombreDeIndicadorElegido;
	private List<String> nombresDeIndicadoresExistentes;
	
	public MetodologiaBuilder getMiMetodologiaBuilder() {
		return miMetodologiaBuilder;
	}

	public void setMiMetodologiaBuilder(MetodologiaBuilder miMetodologiaBuilder) {
		this.miMetodologiaBuilder = miMetodologiaBuilder;
	}

	public String getNombreDeIndicadorElegido() {
		return nombreDeIndicadorElegido;
	}

	public void setNombreDeIndicadorElegido(String nombreDeIndicadorElegido) {
		this.nombreDeIndicadorElegido = nombreDeIndicadorElegido;
	}

	public List<String> getNombresDeIndicadoresExistentes() {
		return nombresDeIndicadoresExistentes;
	}

	public void setNombresDeIndicadoresExistentes(List<String> nombresDeIndicadoresExistentes) {
		this.nombresDeIndicadoresExistentes = nombresDeIndicadoresExistentes;
	}

	public VMMasCondiciones(MetodologiaBuilder _MiMetodologiaBuilder){
		super();
		miMetodologiaBuilder = _MiMetodologiaBuilder;
		setNombresDeIndicadoresExistentes(IndicadoresRepository.getInstancia().getNombresIndicadores());
	}
	
	public void iniciarBuilder(){
	miMetodologiaBuilder.setIndicadorSeleccionado(this.devolverIndicador());
	}
	
	public Indicador devolverIndicador() {
		return IndicadoresRepository.getInstancia().getIndicador(nombreDeIndicadorElegido);	
	}
}
