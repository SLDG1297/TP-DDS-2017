package sistemaDeInversiones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

@Observable
public class VMTablaCuentas {
	
	private Empresa empresaSeleccionada;
	private List<Cuenta> listaDeCuentas; //Representaria la lista de objetos cuenta de una empresa
	private List<String> listaDeNombresDeCuentas;//Solo para probar el selector por ahora
	
	VMTablaCuentas(Empresa empresa_Seleccionada) {
		empresaSeleccionada = empresa_Seleccionada;
		listaDeCuentas = this.buscarCuentas();
		listaDeNombresDeCuentas = this.nombresDeCuentas();
	}
	
	//Luego se saca esto si no es necesario***********************
	public List<String> getListaDeNombresDeCuentas() {
		return listaDeNombresDeCuentas;
	}

	public void setListaDeNombresDeCuentas(List<String> listaDeNombresDeCuentas) {
		this.listaDeNombresDeCuentas = listaDeNombresDeCuentas;
	}
    //**********************************************************
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private String nombre = this.nombresDeCuentas().get(0); //Representaria el nombre de SOLO UNA cuenta
	
	//Retorna la lista de objetos cuentas de la empresa de la vista anterior
	public List<Cuenta> buscarCuentas() {
		return empresaSeleccionada.getCuentas();
	}

	//Retorna una lista de nombres, de la lista de objetos cuentas
	public List<String> nombresDeCuentas() {
		List<String> nombres = listaDeCuentas.stream().map((Cuenta e) -> e.getNombre()).collect(Collectors.toList());
		return nombres;
	}
	
}
