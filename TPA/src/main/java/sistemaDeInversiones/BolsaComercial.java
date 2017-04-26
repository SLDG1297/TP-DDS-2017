package sistemaDeInversiones;

import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

@Observable
public class BolsaComercial {
	private List<Empresa> empresas;
	private List<String> nombresDeEmpresas;

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<String> getNombresDeEmpresas() {
		return nombresDeEmpresas;
	}

	public void setNombresDeEmpresas(List<String> nombresDeEmpresas) {
		nombresDeEmpresas = this.buscarNombresDeEmpresas();
	}

	public Empresa buscarEmpresa(String unNombre) {
		Empresa empresaBuscada = this.empresas.stream().filter((Empresa e) -> e.getNombre() == unNombre).findFirst()
				.get();
		return empresaBuscada;
	}

	public List<String> buscarNombresDeEmpresas() {
		List<String> nombres = this.empresas.stream().map((Empresa e) -> e.getNombre()).collect(Collectors.toList());
		return nombres;
	}

	public void agregarEmpresa(Empresa unaEmpresa) {
		this.empresas.add(unaEmpresa);
	}
}
