package sistemaDeInversiones;

import java.util.ArrayList;
import java.util.List;

public class Periodo {
	Integer anio;
	List<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	public Periodo(Integer nuevoAnio, List<Cuenta> nuevasCuentas) {
		anio = nuevoAnio;
		cuentas = nuevasCuentas;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

}
