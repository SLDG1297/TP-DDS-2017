package View.Metodologias.Comparacion;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import Modelo.Empresa.BolsaDeEmpresas;
import Modelo.Empresa.Empresa;
import Modelo.Metodologias.Metodologia;
import Modelo.Metodologias.MetodologiasRepository;

@Observable
public class VMEvaluacionUnitaria {
	
	public List<String> listaDeEmpresas;
	public List<String> listaDeMetodologias;
	public String nombreEmpresaElegida;
	public Empresa empresaElegida;
	public String nombreMetodologiaElegida;
	public Metodologia metodologiaElegida;
	
	public VMEvaluacionUnitaria (){
		
		super();
		listaDeEmpresas = BolsaDeEmpresas.getInstancia().getNombresDeEmpresas();
		listaDeMetodologias = MetodologiasRepository.getInstancia().nombresDeMetodologias();
		
	}
	
	public void buscarEmpresa() {
		setEmpresaElegida(BolsaDeEmpresas.getInstancia().buscarEmpresa(getNombreEmpresaElegida()));
	}
	
public void buscarMetodologia(){
		
		setMetodologiaElegida(MetodologiasRepository.getInstancia().obtenerMetodologia(nombreMetodologiaElegida));
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

	public String getNombreEmpresaElegida() {
		return nombreEmpresaElegida;
	}

	public void setNombreEmpresaElegida(String nombreEmpresaElegida) {
		this.nombreEmpresaElegida = nombreEmpresaElegida;
	}

	public Empresa getEmpresaElegida() {
		return empresaElegida;
	}

	public void setEmpresaElegida(Empresa empresaElegida) {
		this.empresaElegida = empresaElegida;
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
	
}