package sistemaDeInversiones;

import org.uqbar.commons.utils.Observable;

@Observable
public class Cuenta {
	String nombre;
	int valor;
	int periodo;
	
	public Cuenta(String nombre, int valor, int periodo) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.periodo = periodo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	public void mostrarValor() {
		this.getValor();
	}
}
