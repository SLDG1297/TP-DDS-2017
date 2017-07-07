package View.Metodologias;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import Modelo.Empresa.BolsaDeEmpresas;
import Modelo.Empresa.Empresa;
import Modelo.Metodologias.Metodologia;
import Modelo.Metodologias.MetodologiasRepository;

@Observable
public class VMEvaluacionGlobal {

	public List<String> listaDeMetodologias;
	public String nombreMetodologiaElegida;
	public Metodologia metodologiaElegida;

	public String getNombreMetodologiaElegida() {
		return nombreMetodologiaElegida;
	}

	public void setNombreMetodologiaElegida(String nombreMetodologiaElegida) {
		this.nombreMetodologiaElegida = nombreMetodologiaElegida;
	}

	public Metodologia getMetodologiaElegida() {
		return metodologiaElegida;
	}

	public void setMetodologiaElegida(Metodologia metodologiaElegida) {
		this.metodologiaElegida = metodologiaElegida;
	}

	public List<String> getListaDeMetodologias() {
		return listaDeMetodologias;
	}

	public void setListaDeMetodologias(List<String> listaDeMetodologias) {
		this.listaDeMetodologias = listaDeMetodologias;
	}

	public VMEvaluacionGlobal() {
		super();
		listaDeMetodologias = MetodologiasRepository.getInstancia().nombresDeMetodologias();
	}

	public void buscarMetodologia() {

		setMetodologiaElegida(MetodologiasRepository.getInstancia().obtenerMetodologia(nombreMetodologiaElegida));
	}
}
	
	
