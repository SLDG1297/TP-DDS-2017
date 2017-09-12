package View.Metodologias;

import java.util.List;

import org.uqbar.commons.utils.Observable;

import DB.IndicadoresRepository;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.MetodologiaBuilder;

@Observable
public class VMSeleccionCondicion {
	
	private String nombreMetodologia;
	public String nombreDeIndicadorElegido;
	private List<String> nombresDeIndicadoresExistentes;
	
	private MetodologiaBuilder miMetodologiaBuilder;
	
	//Constructor
	public VMSeleccionCondicion(MetodologiaBuilder _MiMetodologiaBuilder){
		super();
		miMetodologiaBuilder = _MiMetodologiaBuilder;
		this.setNombresDeIndicadoresExistentes(IndicadoresRepository.getInstancia().getNombresIndicadores());
	}

	/*--------------------------------------------------------------------------------------*/ //Comienzo de los getters y setters
	public String getNombreMetodologia() {
		return nombreMetodologia;
	}

	public void setNombreMetodologia(String nombreMetodologia) {
		this.nombreMetodologia = nombreMetodologia;
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

	public MetodologiaBuilder getMiMetodologiaBuilder() {
		return miMetodologiaBuilder;
	}

	public void setMiMetodologiaBuilder(MetodologiaBuilder miMetodologiaBuilder) {
		this.miMetodologiaBuilder = miMetodologiaBuilder;
	}
	
	public String getMiCadena() {
		return miMetodologiaBuilder.mostrarCadena();
	}
	
	/*--------------------------------------------------------------------------------------*/ //Final de los getters y setters
	
	public Indicador devolverIndicador() {
		return IndicadoresRepository.getInstancia().getIndicador(nombreDeIndicadorElegido);	
	}

	public void iniciarBuilder(){
		miMetodologiaBuilder.setIndicadorSeleccionado(devolverIndicador());
	}
	
}
