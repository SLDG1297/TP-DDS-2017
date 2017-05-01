package sistemaDeInversiones;

import java.util.List;

public class Cuenta {
	String nombre;
	int valor;
	
	public Cuenta() {
		
	}
	
	public Cuenta(String nuevoNombre, int nuevoValor) {
		this.nombre = nuevoNombre;
		this.valor = nuevoValor;
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

}
