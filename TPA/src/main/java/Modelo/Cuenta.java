package Modelo;

import org.uqbar.commons.utils.Observable;

@Observable
public class Cuenta {
	String nombre;
	Integer valor;
	
	public Cuenta(String nuevoNombre, Integer nuevoValor) {
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
