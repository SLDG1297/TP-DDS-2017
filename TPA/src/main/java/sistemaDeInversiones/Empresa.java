package sistemaDeInversiones;

import java.util.List;
import org.uqbar.commons.utils.Observable;

@Observable
public class Empresa {
	private String nombre;
	private List<Cuenta> cuentas;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public void cargarCuentas(List<Cuenta> unasCuentas, int unPeriodo) {
		// Consultar archivo de cuentas y cargarlas.
	}

	public void consultarCuentas() {
		this.getCuentas();
	}
}
