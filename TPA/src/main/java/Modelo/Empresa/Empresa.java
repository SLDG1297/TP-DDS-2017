package Modelo.Empresa;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.uqbar.commons.utils.Observable;

import Excepciones.Empresas.NoExisteElPeriodoException;


@Observable
public class Empresa {
	private String nombre;
	private List<Periodo> periodos = new ArrayList<Periodo>();
	
	// Esto solo lo usa el Parser para crear la empresa rápidamente
	public Empresa(String nombre, String nombreCuenta, String anio, String valorCuenta) {
		this.nombre =  nombre;		
		periodos.add(new Periodo(Integer.parseInt(anio), new Cuenta(nombreCuenta, Integer.parseInt(valorCuenta))));
	}
	
	public Empresa(String nuevoNombre, List<Periodo> nuevosPeriodos) {
		nombre = nuevoNombre;
		periodos = nuevosPeriodos;
	}

	public Empresa(String nuevoNombre, Periodo nuevoPeriodo) { // Agregar un periodo
		nombre = nuevoNombre;
		periodos.add(nuevoPeriodo);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}
	
	public List<Integer> obtenerPeriodos(){
		List<Integer> periodosEmpresa = this.getPeriodos().stream().map(p -> p.getAnio()).collect(Collectors.toList());
		return periodosEmpresa;
	}
	
	public List<Cuenta> obtenerCuentasEnPeriodo(int periodo){
		Periodo periodoSeleccionado = this.getPeriodos().stream().filter(p -> p.getAnio() == periodo).findFirst().get();
		
		if(periodoSeleccionado.getAnio() != periodo) throw new NoExisteElPeriodoException();
		
		List<Cuenta> cuentas = periodoSeleccionado.getCuentas();
		
	    return cuentas;
	}
}

