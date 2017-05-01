package sistemaDeInversiones;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class VMBolsaComercial {

	// Para bindear items del selector de empresas
	public List<String> listaDeNombresDeEmpresas;
	public String nombreEmpresa;
	//Empresa seleccionada en el selector
	public Empresa empresa;
	public bolsaDeEmpresasParasito bolsaEmpresas;
	//Para bindear items del selector de periodos de la empresa elegida
	public int periodoElegido;
	public List<Integer> listaDePeriodosDeEmpresa;
	

	
	public int getPeriodoElegido() {
		return periodoElegido;
	}

	public void setPeriodoElegido(int periodoElegido) {
		this.periodoElegido = periodoElegido;
	}

	public List<Integer> getListaDePeriodosDeEmpresa() {
		return listaDePeriodosDeEmpresa;
	}

	public void setListaDePeriodosDeEmpresa(List<Integer> listaDePeriodosDeEmpresa) {
		this.listaDePeriodosDeEmpresa = listaDePeriodosDeEmpresa;
	}

	public VMBolsaComercial(bolsaDeEmpresasParasito bolsaEmpresas) {
		super();
		this.bolsaEmpresas = bolsaEmpresas;
		listaDeNombresDeEmpresas = this.buscarNombresDeEmpresas();
	}

	public bolsaDeEmpresasParasito getBolsaEmpresas() {
		return bolsaEmpresas;
	}

	public void setBolsaEmpresas(bolsaDeEmpresasParasito bolsaEmpresas) {
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

	public void buscarEmpresa() {
		//recordar cambiar a la bolsa de empresas NO parasito
		empresa = this.bolsaEmpresas.buscarEmpresa(nombreEmpresa);
	}

	public List<String> buscarNombresDeEmpresas() {
		//recordar cambiar a la bolsa de empresas NO parasito
		return this.bolsaEmpresas.buscarNombresDeEmpresas();
	}
	public List<Integer> buscarPeriodosDeEmpresa(){
		//recordar cambiar a la bolsa de empresas NO parasito
		return this.empresa.
	}
}
