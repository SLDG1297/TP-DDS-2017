package Modelo.Metodologias;

import java.util.ArrayList;
import java.util.List;
import Modelo.Metodologias.Condiciones.Condiciones;
import Modelo.Empresa.Empresa;

public class Metodologia {

	private String nombre;
	private List<Condiciones> listaCondiciones = new ArrayList<Condiciones>();
	
	//Para crearse debe tener al menos una condicion, no se como afectara esto en la vista
	//Supongo que haran un builder, seria lo mas logico asi no cambian el modelo
	public Metodologia(String nombre, Condiciones condicion) {
		this.nombre = nombre;
		this.addCondicion(condicion);
	}
	
	public Metodologia(String nombre, List<Condiciones> condiciones){
		this.nombre = nombre;
		this.listaCondiciones = condiciones;
	}
	
	public void addCondicion(Condiciones condicion){
		listaCondiciones.add(condicion);
	}
	
	public boolean cumple(Empresa empresa){
		return listaCondiciones.stream().allMatch(condicion -> condicion.cumple(empresa));
	}

	public String getNombre() {
		return nombre;
	}

	public List<Condiciones> getListaCondiciones() {
		return listaCondiciones;
	}

}
