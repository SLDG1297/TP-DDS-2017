package Modelo.Empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Exepciones.Empresas.NoExisteLaEmpresaException;

public class BolsaDeEmpresas {
	
	private static BolsaDeEmpresas bolsa = null;
	
	// Con unas empresas para probar las vistas.
	private List<Empresa> empresas = new ArrayList<Empresa>();
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresasNuevas) {
		empresas = empresasNuevas;
	}

	public Empresa buscarEmpresa(String unNombre) {
		Empresa empresaBuscada = bolsa.getEmpresas().stream().filter( e -> e.getNombre().equals(unNombre)).findFirst().get();
		
		if(empresaBuscada.getNombre() != unNombre) throw new NoExisteLaEmpresaException();
		
		return empresaBuscada;
	}
	
	public List<String> getNombresDeEmpresas() {
		return bolsa.getEmpresas().stream().map((Empresa e) -> e.getNombre()).collect(Collectors.toList());		
	}
	
    public static BolsaDeEmpresas getInstancia() {
		
		if(bolsa == null){
			bolsa = new BolsaDeEmpresas();
		}
		
		return bolsa;
	}
}
