package Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BolsaDeEmpresas {
	
	private static BolsaDeEmpresas instancia = null;
	
	// Con unas empresas para probar las vistas.
	private List<Empresa> empresas = new ArrayList<Empresa>();
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresasNuevas) {
		empresas = empresasNuevas;
	}

	public Empresa buscarEmpresa(String unNombre) {
		return instancia.getEmpresas().stream().filter( e -> e.getNombre().equals(unNombre)).findFirst().get();
	}
	
	public List<String> buscarNombresDeEmpresas() {
		return instancia.getEmpresas().stream().map((Empresa e) -> e.getNombre()).collect(Collectors.toList());		
	}
	
    public static BolsaDeEmpresas getInstancia() {
		
		if(instancia == null){
			instancia = new BolsaDeEmpresas();
		}
		
		return instancia;
	}
}
