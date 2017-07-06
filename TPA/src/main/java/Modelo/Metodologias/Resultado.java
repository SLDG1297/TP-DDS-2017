package Modelo.Metodologias;

import java.util.ArrayList;
import java.util.List;

import Modelo.Empresa.Empresa;

public abstract class Resultado {
			
	protected List<Empresa> listaEmpresas = new ArrayList<Empresa>();

	public Resultado(Empresa empresa){
		this.listaEmpresas.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return listaEmpresas;
	}
	
	
	
}
