package DB.Repositorios;

import DB.Repositorio;
import Modelo.Empresa.Empresa;

public class RepositorioEmpresas extends Repositorio<Empresa> {
	public static RepositorioEmpresas instancia = null;
	
	@Override
	public String getTipo() {
		return Empresa.class.getSimpleName();
	}
	
	public static RepositorioEmpresas getInstancia() {
		if(instancia == null) instancia = new RepositorioEmpresas();
		
		return instancia;
	}
	
}
