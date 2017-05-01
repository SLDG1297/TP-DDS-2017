package sistemaDeInversiones;

import java.util.ArrayList;
import java.util.List;

public class Periodo {
	int anio;
	List<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	public Periodo() {
		
	}
	
	public Periodo(int nuevoAnio, List<Cuenta> nuevasCuentas) {
		anio = nuevoAnio;
		cuentas = nuevasCuentas;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

}
