package Modelo.Empresa;

import java.util.ArrayList;
import java.util.List;

import Exepciones.Empresas.NoExisteElPeriodoException;
import Exepciones.Indicadores.NoTieneLaCuentaException;
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
	
	public Cuenta buscarCuenta(String nombreCuenta){
		return this.cuentas.stream().filter(c -> c.getNombre().equals(nombreCuenta)).findFirst().orElseThrow(()-> new NoTieneLaCuentaException());
	}

}
