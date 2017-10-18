package View.Metodologias;

import java.util.List;

import DB.Repositorios.RepositorioMetodologias;
import org.uqbar.commons.utils.Observable;

@Observable
public class VMEliminarMetodologias {

	public String nombreDeMetodologiaElegida;
	public List<String> nombresDeMetodologiasExistentes = RepositorioMetodologias.getInstancia().darListaNombres();
	
	public void destruirMetodologiaSeleccionada() {
		RepositorioMetodologias.getInstancia().eliminarObjeto(RepositorioMetodologias.getInstancia().buscarObjeto(nombreDeMetodologiaElegida));
	}
	
	public void setNombreDeMetodologiaElegida(String nombreMetodologiaElegida) {
		this.nombreDeMetodologiaElegida = nombreMetodologiaElegida;
	}
	
	public void setNombresDeMetodologiasExistentes(List<String> arre) {
		// Hace falta?
	}
	
	public String getNombreDeMetodologiaElegida() {
		return this.nombreDeMetodologiaElegida;
	}
	
	public List<String> getNombresDeMetodologiasExistentes() {
		return nombresDeMetodologiasExistentes;
	}

}
