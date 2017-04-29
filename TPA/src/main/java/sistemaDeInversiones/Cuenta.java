package sistemaDeInversiones;

import java.util.List;

public class Cuenta {
	String nombre;
	List<Periodo> periodos;
	
	public Cuenta(String nombre, List<Periodo> periodos) {
		this.nombre = nombre;
		this.periodos = periodos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}
}
