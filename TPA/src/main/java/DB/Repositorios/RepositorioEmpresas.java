package DB.Repositorios;

import static DB.NombreRepositorio.*;

import DB.NombreRepositorio;
import DB.Repositorio;
import Modelo.Empresa.Empresa;

public class RepositorioEmpresas extends Repositorio<Empresa> {
	private static RepositorioEmpresas instancia = null;
	
	private RepositorioEmpresas(NombreRepositorio nombreTabla) {
		super(nombreTabla);
	}
	
	public static RepositorioEmpresas getInstancia() {
		if(instancia == null) instancia = new RepositorioEmpresas(EMPRESA);
		
		return instancia;
	}
	
}
