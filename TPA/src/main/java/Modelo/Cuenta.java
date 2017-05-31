package Modelo;

import java.math.BigDecimal;

import org.uqbar.commons.utils.Observable;

@Observable
public class Cuenta implements Expresion{
	String nombre;
	Integer valor;
	
	public Cuenta(String nuevoNombre, Integer nuevoValor) {
		this.nombre = nuevoNombre;
		this.valor = nuevoValor;
	}
	
	public Cuenta(String nuevoNombre){
		this.nombre = nuevoNombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public BigDecimal calcular(Query query) {
		return query.obtenerValorCuenta(this.nombre);
	}

}
