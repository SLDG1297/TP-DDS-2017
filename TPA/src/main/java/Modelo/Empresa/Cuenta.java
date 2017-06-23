package Modelo.Empresa;

import java.math.BigDecimal;
import org.uqbar.commons.utils.Observable;
import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.Query;

@Observable
public class Cuenta implements Expresion {
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
		return query.getEmpresa().buscarValorCuentaEnPeriodo(this.nombre,query.getPeriodo());
	}
	
	public void addOperando(Expresion operando){
		/*this.a = operando;*/
	}
	
	public String imprimirFormulaindicador(){
		return "";
	}

}
