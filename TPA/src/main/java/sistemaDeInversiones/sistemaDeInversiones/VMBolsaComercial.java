package sistemaDeInversiones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

@Observable
public class VMBolsaComercial {

	// Para bindear items del selector. También con un valor asignado para probar la vista.
	public List<String> listaDeNombresDeEmpresas = this.buscarNombresDeEmpresas();
	// Para bindear valores en el selector. Idem "nombresEmpresas".
	public String nombreEmpresa;
	
	
	
	public List<String> getListaDeNombresDeEmpresas() {
		return listaDeNombresDeEmpresas;
	}

	public void setNombresEmpresas(List<String> nombresEmpresas) {
		this.listaDeNombresDeEmpresas = this.buscarNombresDeEmpresas();
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = this.buscarEmpresa(nombreEmpresa).getNombre();
	}

	public Empresa buscarEmpresa(String unNombre) {
		return bolsaDeEmpresas.buscarEmpresa(unNombre);
	}

	public List<String> buscarNombresDeEmpresas() {
		return bolsaDeEmpresas.buscarNombresDeEmpresas();
	}
}
