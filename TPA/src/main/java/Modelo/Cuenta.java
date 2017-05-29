package Modelo;

import org.uqbar.commons.utils.Observable;

@Observable
public class Cuenta {
	String nombre;
	Integer valor;
	
	public Cuenta(Object object2, Integer nuevoValor) {
		this.nombre = (String) object2;
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
