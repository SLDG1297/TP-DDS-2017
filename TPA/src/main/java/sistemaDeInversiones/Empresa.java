package sistemaDeInversiones;

import java.util.Arrays;
import java.util.List;
import org.uqbar.commons.utils.Observable;

@Observable
public class Empresa {
	private String nombre;
	private List<Cuenta> cuentas;

	public Empresa(String nombre) {
		super();
		this.nombre = nombre;
	}

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

	public void cargarCuentas() {
		// Acá se accede al archivo para cargar las cuentas de la empresa.
		// Originalmente pensamos en hacer una clase estática "Bolsa de Valores" para que cargue todo.
		// Pero tratamos de hacer la clase estática y tuvimos problemas...
		// Así que...
		// De momento, esto va a estar hardcodeado con unas cuentas de prueba para visualizar en la vista.
		Cuenta cuenta1 = new Cuenta("EDITBA", 1000, 2010);
		Cuenta cuenta2 = new Cuenta("Free Cash Flow", 2000, 1999);
		List<Cuenta> lista = Arrays.asList(cuenta1, cuenta2);
		this.setCuentas(lista);
	}

	public void consultarCuentas() {
		this.getCuentas();
	}
}
