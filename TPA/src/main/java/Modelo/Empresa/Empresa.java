package Modelo.Empresa;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.uqbar.commons.utils.Observable;

import Exepciones.Empresas.NoExisteElPeriodoException;
import Exepciones.Indicadores.NombreCuentaErroneoException;


@Observable
public class Empresa {
	private String nombre;
	private List<Periodo> periodos = new ArrayList<Periodo>();
	
	// Esto solo lo usa el Parser para crear la empresa rápidamente
	public Empresa(Object object, Object object2, Object object3, Object object4) {
		nombre = (String) object;		
		periodos.add(new Periodo(Integer.parseInt((String) object3), new Cuenta(object2, Integer.parseInt((String) object4))));
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
	
	public Cuenta buscarCuenta(List<Cuenta> cuentas, String nombreCuenta){
		List<Cuenta> cuentaEncontrada = cuentas.stream().filter(c -> c.getNombre().equals(nombreCuenta)).collect(Collectors.toList());
		if(cuentaEncontrada.size() == 0)
			throw new NombreCuentaErroneoException();
		else
			return cuentaEncontrada.get(0);
	}
	
	public BigDecimal buscarValorCuentaEnPeriodo(String nombreCuenta, Integer periodo){
		List<Cuenta> cuentas = this.obtenerCuentasEnPeriodo(periodo);
		Cuenta cuenta = this.buscarCuenta(cuentas, nombreCuenta);
		return new BigDecimal(cuenta.getValor().toString());		
	}
}

