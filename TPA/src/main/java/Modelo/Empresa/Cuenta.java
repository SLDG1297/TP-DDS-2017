package Modelo.Empresa;

import java.math.BigDecimal;
import org.uqbar.commons.utils.Observable;
import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.Query;

@Observable
public class Cuenta extends Expresion {
	String nombre;
	Integer valor;

	public Cuenta(Object object2, Integer nuevoValor) {
		this.nombre = (String) object2;
		this.valor = nuevoValor;
	}

	public Cuenta(String nuevoNombre) {
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
		/*
		 * try{ return query.obtenerValorCuenta(this.nombre); }
		 * catch(NombreCuentaErroneoException e){ //Hay que tratar excepción de
		 * alguna forma }
		 */
	}
	
	public void addOperando(Expresion operando){
		/*this.a = operando;*/
	}

}
