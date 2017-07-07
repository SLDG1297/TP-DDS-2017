package View.Metodologias;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import Archivo.Metodologias.AlmacenadorDeMetodologias;
import Modelo.Metodologias.MetodologiasRepository;

@Observable
public class VMEliminarMetodologias {

	public String nombreDeMetodologiaElegida;
	public List<String> nombresDeMetodologiasExistentes = MetodologiasRepository.getInstancia().nombresDeMetodologias();
	
	public void destruirMetodologiaSeleccionada() {
		MetodologiasRepository.getInstancia().removerMetodologia(nombreDeMetodologiaElegida);
		try {
			AlmacenadorDeMetodologias.getInstancia().almacenarRepositorioMetodologias();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
