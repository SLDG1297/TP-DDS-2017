package Modelo.Empresa;

import java.math.BigDecimal;
import org.uqbar.commons.utils.Observable;
import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.Query;

@Observable
public class Cuenta implements Expresion, Deserializa {
	String nombre;
	Integer valor;

	public Cuenta(String nombre, Integer nuevoValor) {
		this.nombre = nombre;
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
		return new BigDecimal(query.getEmpresa().buscarPeriodo(query.getPeriodo()).buscarCuenta(this.nombre).getValor());
	}
	
	public void addOperando(Expresion operando){
		
	}
	
	public String imprimirFormulaindicador(){
		return "";
	}

}
