package View.Cuentas;
import java.util.List;
import org.uqbar.commons.utils.Observable;

import DB.Repositorios.EmpresasRepository;
import Modelo.Empresa.Empresa;

@Observable
public class VMCargarCuentas {

	// Para bindear items del selector de empresas
	public List<String> listaDeNombresDeEmpresas;
	public String nombreEmpresa;
	//Empresa seleccionada en el selector 
	public Empresa empresa;
	public EmpresasRepository bolsaEmpresas;
	//Para bindear items del selector de periodos de la empresa elegida
	public Integer periodoElegido;
	public List<Integer> listaDePeriodosDeEmpresa;
	
	//Constructor
	public VMCargarCuentas() {
		super();
		bolsaEmpresas = EmpresasRepository.getInstancia();
		listaDeNombresDeEmpresas = this.buscarNombresDeEmpresas();
	}

	public Integer getPeriodoElegido() {
		return periodoElegido;
	}


	public void setPeriodoElegido(Integer periodoElegido) {
		this.periodoElegido = periodoElegido;
	}


	public List<Integer> getListaDePeriodosDeEmpresa() {
		return listaDePeriodosDeEmpresa;
	}


	public void setListaDePeriodosDeEmpresa(List<Integer> listaDePeriodosDeEmpresa) {
		this.listaDePeriodosDeEmpresa = listaDePeriodosDeEmpresa;
	}


	public EmpresasRepository getBolsaEmpresas() {
		return bolsaEmpresas;
	}

	public void setBolsaEmpresas(EmpresasRepository bolsaEmpresas) {
		this.bolsaEmpresas = bolsaEmpresas;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setListaDeNombresDeEmpresas(List<String> listaDeNombresDeEmpresas) {
		this.listaDeNombresDeEmpresas = listaDeNombresDeEmpresas;
	}

	public List<String> getListaDeNombresDeEmpresas() {
		return listaDeNombresDeEmpresas;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombre_Empresa) {
		this.nombreEmpresa = nombre_Empresa;
	}

	//Sirve para actualizar el VM con la empresa seleccionada a partir de su nombre y además 
	//obtener la lista de periodos correspondientes a esa empresa
	public void buscarEmpresaYSusPeriodos() {
		empresa = this.bolsaEmpresas.buscarEmpresa(nombreEmpresa);
		this.listaDePeriodosDeEmpresa = this.buscarPeriodosDeEmpresa();
	}
    
	public List<String> buscarNombresDeEmpresas() {
		return this.bolsaEmpresas.getNombresDeEmpresas();
	}
	
	public List<Integer> buscarPeriodosDeEmpresa(){
		return this.empresa.obtenerAniosDeTodosLosPeriodos();
	}
}
