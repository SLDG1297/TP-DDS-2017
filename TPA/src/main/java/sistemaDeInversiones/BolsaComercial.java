package sistemaDeInversiones;

import java.util.List;
import java.util.Optional;
import org.uqbar.commons.utils.Observable;

@Observable
public class BolsaComercial {
	private List<Empresa> empresas;

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Empresa buscarEmpresa(String unNombre) {
		Optional<Empresa> empresaBuscada = this.empresas.stream().filter((Empresa e) -> e.getNombre() == unNombre).findFirst();
		Empresa unaEmpresa = empresaBuscada.get();
		return unaEmpresa;
	}
}
