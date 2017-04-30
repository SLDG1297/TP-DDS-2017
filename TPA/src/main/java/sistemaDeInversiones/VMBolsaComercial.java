package sistemaDeInversiones;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class VMBolsaComercial {

	// Para bindear items del selector. También con un valor asignado para probar la vista.
	public List<String> listaDeNombresDeEmpresas;
	// Para bindear valores en el selector.
	public String nombreEmpresa;
	public Empresa empresa;
	public bolsaDeEmpresasParasito bolsaEmpresas = new bolsaDeEmpresasParasito();
	

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
}
