package sistemaDeInversiones;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

@Observable
public class BolsaComercial {
	// Con unas empresas para probar las vistas.
	private List<Empresa> empresas = Arrays.asList(new Empresa(), new Empresa());
	// Para bindear items del selector. También con un valor asignado para probar la vista.
	private List<String> nombresEmpresas = this.buscarNombresDeEmpresas();
	// Para bindear valores en el selector. Idem "nombresEmpresas".
	private String nombreEmpresa = nombresEmpresas.get(0);

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<String> getNombresEmpresas() {
		return nombresEmpresas;
	}

	public void setNombresEmpresas(List<String> nombresEmpresas) {
		this.nombresEmpresas = this.buscarNombresDeEmpresas();
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = this.buscarEmpresa(nombreEmpresa).getNombre();
	}

	public Empresa buscarEmpresa(String unNombre) {
		Empresa empresaBuscada = this.empresas.stream().filter((Empresa e) -> e.getNombre() == unNombre).findFirst().get();
		return empresaBuscada;
	}

	public List<String> buscarNombresDeEmpresas() {
		List<String> nombres = this.empresas.stream().map((Empresa e) -> e.getNombre()).collect(Collectors.toList());
		return nombres;
	}
}
