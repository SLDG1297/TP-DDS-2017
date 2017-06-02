package Modelo;

import java.util.ArrayList;
import java.util.List;

public class CadenaActualDeMiIndicador {
	
	private static CadenaActualDeMiIndicador instancia = null;
	
	private List<String> cadenaActual = new ArrayList<String>(); // Esto permite borrar algo que hayamos agregado si se quiere complejizar el sistema.
	
	public static CadenaActualDeMiIndicador instanciar() {
		if(instancia == null) {
			instancia = new CadenaActualDeMiIndicador();
		}
		
		return instancia;
	}
	
	public void eliminarCadenaActual() { // Una vez finalizado el indicador se tiene que enviar este mensaje
		cadenaActual = new ArrayList<String>();
	}
	
	public void agregar(String cadena) {
		this.cadenaActual.add(cadena);
	}
	
	public void removerUltimoAgregado() {
		this.cadenaActual.remove(cadenaActual.size() - 1);
	}
	
	public String mostrarCadenaActual() {
		return String.join(" ", cadenaActual);
	}
	
	// GET Y SET
	
	public List<String> getCadenaActual() {
		return cadenaActual;
	}
	
	public void setCadenaActual(List<String> nuevaCadena) {
		cadenaActual = nuevaCadena;
	}
	
}