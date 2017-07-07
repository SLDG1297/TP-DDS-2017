package View.Metodologias.Comparacion;

import java.util.List;
import org.uqbar.commons.utils.Observable;

import Modelo.Empresa.BolsaDeEmpresas;
import Modelo.Empresa.Empresa;
import Modelo.Metodologias.Metodologia;
import Modelo.Metodologias.MetodologiasRepository;


@Observable
public class VMEvaluacionMultiple {
	
	public List<String> listaDeEmpresas;
	public List<String> listaDeMetodologias;
	public String nombreEmpresa;
	public Empresa empresa;
	public String nombreMetodologiaElegida;
	public Metodologia metodologiaElegida;
	
	public VMEvaluacionMultiple() {
		
		super();
		listaDeEmpresas = BolsaDeEmpresas.getInstancia().getNombresDeEmpresas();
		listaDeMetodologias = MetodologiasRepository.getInstancia().nombresDeMetodologias();
		
		}
	
	public void buscarEmpresa() {
		this.setEmpresa(BolsaDeEmpresas.getInstancia().buscarEmpresa(nombreEmpresa));
	}

	public List<String> getListaDeEmpresas() {
		return listaDeEmpresas;
	}

	public void setListaDeEmpresas(List<String> listaDeEmpresas) {
		this.listaDeEmpresas = listaDeEmpresas;
	}

	public List<String> getListaDeMetodologias() {
		return listaDeMetodologias;
	}

	public void setListaDeMetodologias(List<String> listaDeMetodologias) {
		this.listaDeMetodologias = listaDeMetodologias;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

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
	
	public void buscarMetodologia(){
		
		this.setMetodologiaElegida(MetodologiasRepository.getInstancia().obtenerMetodologia(nombreMetodologiaElegida));
	}
	
}