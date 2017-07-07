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
public class VMEvaluacionDual {
	
	public List<String> listaDeEmpresas;
	public List<String> listaDeMetodologias;
	public List<String> listaDeEmpresasSinEmpresaA;
	public String nombreEmpresaA;
	public String nombreEmpresaB;
	public Empresa empresaA;
	public Empresa empresaB;
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


	public List<String> getListaDeEmpresasSinEmpresaA() {
		return listaDeEmpresasSinEmpresaA;
	}


	public void setListaDeEmpresasSinEmpresaA(List<String> listaDeEmpresasSinEmpresaA) {
		this.listaDeEmpresasSinEmpresaA = listaDeEmpresasSinEmpresaA;
	}



	
	public Empresa getEmpresaA() {
		return empresaA;
	}


	

	public String getNombreEmpresaA() {
		return nombreEmpresaA;
	}




	public void setNombreEmpresaA(String nombreEmpresaA) {
		this.nombreEmpresaA = nombreEmpresaA;
	}




	public String getNombreEmpresaB() {
		return nombreEmpresaB;
	}




	public void setNombreEmpresaB(String nombreEmpresaB) {
		this.nombreEmpresaB = nombreEmpresaB;
	}




	public Empresa getEmpresaB() {
		return empresaB;
	}




	public void setEmpresaB(Empresa empresaB) {
		this.empresaB = empresaB;
	}




	public void setEmpresaA(Empresa empresaA) {
		this.empresaA = empresaA;
	}


	public VMEvaluacionDual() {
		super();
		listaDeEmpresas = BolsaDeEmpresas.getInstancia().getNombresDeEmpresas();
		listaDeMetodologias = MetodologiasRepository.getInstancia().getNombresDeMetodologias();
		}


	public List<String> getListaDeEmpresas() {
		return listaDeEmpresas;
	}


	public void setListaDeEmpresas(List<String> listaDeEmpresas) {
		this.listaDeEmpresas = listaDeEmpresas;
	}
	
	public void buscarEmpresaA() {
		setEmpresaA(BolsaDeEmpresas.getInstancia().buscarEmpresa(getNombreEmpresaA()));
	}
	
	public void buscarEmpresaB() {
		setEmpresaB(BolsaDeEmpresas.getInstancia().buscarEmpresa(getNombreEmpresaB()));
	}
	
	
	public void generarListaSinA() {
		
		setListaDeEmpresasSinEmpresaA(listaDeEmpresas.stream().filter(x -> !x.equals(nombreEmpresaA)).collect(Collectors.toList()));
		
		}
	
	public void buscarMetodologia(){
		
		setMetodologiaElegida(MetodologiasRepository.getInstancia().buscarMetodologia(nombreMetodologiaElegida));
	}
	
	
	
	
	
	}