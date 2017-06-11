package View.Cuentas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import Modelo.Empresa.Empresa;
import Modelo.Empresa.Cuenta;

@Observable
public class VMTablaCuentas {
	
	//Empresa seleccionada en la vista anterior
	private Empresa empresaSeleccionada;
	private String nombreEmpresa;
	//Periodo seleccionado en la vista anterior
	private Integer periodoSeleccionado;
	//Cuentas asociadas al periodo elegido
	private List<Cuenta> listaDeCuentas = new ArrayList<Cuenta>(); //Representaria la lista de objetos cuenta de una empresa
	private List<String> listaDeNombresDeCuentas = new ArrayList<String>();//Solo para probar el selector por ahora
	
	//Constructor
	VMTablaCuentas(VMCargarCuentas bolsaComercial) {
		empresaSeleccionada = bolsaComercial.getEmpresa();
		nombreEmpresa = empresaSeleccionada.getNombre();
		periodoSeleccionado = bolsaComercial.getPeriodoElegido();
		listaDeCuentas = this.buscarCuentas();
	    listaDeNombresDeCuentas = this.nombresDeCuentas();
	}
	
	
	public String getNombre() {
		return nombreEmpresa;
	}

	public void setNombre(String nombre) {
		this.nombreEmpresa = nombre;
	}

	public List<String> getListaDeNombresDeCuentas() {
		return listaDeNombresDeCuentas;
	}

	public void setListaDeNombresDeCuentas(List<String> listaDeNombresDeCuentas) {
		this.listaDeNombresDeCuentas = listaDeNombresDeCuentas;
	}
	
	public Empresa getEmpresaSeleccionada() {
		return empresaSeleccionada;
	}

	public void setEmpresaSeleccionada(Empresa empresaSeleccionada) {
		this.empresaSeleccionada = empresaSeleccionada;
	}

	public List<Cuenta> getListaDeCuentas() {
		return listaDeCuentas;
	}

	public void setListaDeCuentas(List<Cuenta> listaDeCuentas) {
		this.listaDeCuentas = listaDeCuentas;
	}
	
	//Retorna la lista de cuentas de la empresa de la vista anterior correspondiente al periodo seleccionado
	public List<Cuenta> buscarCuentas() {
		return empresaSeleccionada.obtenerCuentasEnPeriodo(periodoSeleccionado);
	}

	//Retorna una lista de nombres, de la lista de objetos cuentas
	public List<String> nombresDeCuentas() {
		return listaDeCuentas.stream().map((Cuenta e) -> e.getNombre()).collect(Collectors.toList());
	}
	
}
