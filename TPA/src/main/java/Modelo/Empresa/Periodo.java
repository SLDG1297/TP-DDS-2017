package Modelo.Empresa;

import java.util.ArrayList;
import java.util.List;

import Exepciones.Periodos.YaExisteLaCuentaException;
import Modelo.Empresa.Cuenta;

public class Periodo {
	Integer anio;
	List<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	public Periodo(Integer nuevoAnio, List<Cuenta> nuevasCuentas) {
		anio = nuevoAnio;
		cuentas = nuevasCuentas;
	}
	
	// Esto solo lo usa el Parser para crear la empresa rápidamente
	public Periodo(Integer nuevoAnio, Cuenta nuevaCuenta) {
		anio = nuevoAnio;
		cuentas.add(nuevaCuenta);
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
	
	public void agregarCuenta(Cuenta miCuenta) {
		if(this.cuentas.contains(miCuenta)) throw new YaExisteLaCuentaException();
		
		this.cuentas.add(miCuenta);
	}
	
	public boolean estaEntre(int anios, List<Periodo> lista, Periodo periodo){
		if(lista.size() > anios){
			return lista.subList(lista.size()-1-anios, lista.size()-1).contains(periodo);
		}else{
			return true;
		}
	}
}
