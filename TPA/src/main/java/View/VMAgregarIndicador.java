package View;

import java.util.List;
import org.uqbar.commons.utils.Observable;
import Modelo.BolsaDeEmpresas;
import Modelo.Empresa;
import Modelo.Expresion;
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
	
	public Indicador tomarIndicador() {
		
		Indicador indicadorBuscado;
		indicadorBuscado = IndicadoresRepository.getInstancia().getIndicador(nombreDeIndicadorElegido);
		return indicadorBuscado;
		
	}
	
}