package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BolsaDeEmpresas {
	// Con unas empresas para probar las vistas.
	private List<Empresa> empresas = new ArrayList<Empresa>();
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresasNuevas) {
		empresas = empresasNuevas;
	}

	public Empresa buscarEmpresa(String unNombre) {
		Empresa empresaBuscada = this.getEmpresas().stream().filter( e -> e.getNombre().equals(unNombre)).findFirst().get();
		return empresaBuscada;	
	}
	
	public List<String> buscarNombresDeEmpresas() {
		List<String> nombres = this.getEmpresas().stream().map((Empresa e) -> e.getNombre()).collect(Collectors.toList());
		return nombres;		
	}
}
