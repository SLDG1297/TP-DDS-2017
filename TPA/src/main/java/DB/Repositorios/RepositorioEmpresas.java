package DB.Repositorios;

import static DB.TiposDeRepositorios.NombreRepositorio.EMPRESA;

import Archivo.CargaBatch.EmpresaToken;
import DB.TiposDeRepositorios.NombreRepositorio;
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
	
	public void modificarEmpresa(EmpresaToken token) {
		this.buscarObjeto(token.getNombreEmpresa()).actualizar(token);;
	}
	
}
