package Archivo.CargaBatch;

import DB.Excepciones.NoExisteObjetoConEseNombreException;
import DB.Repositorios.RepositorioEmpresas;
import Modelo.Empresa.Empresa;

public class ReceptorDeEmpresas {
	private static ReceptorDeEmpresas instancia = null;
	
	private ReceptorDeEmpresas() { }
	
	public static ReceptorDeEmpresas instanciar() {
		if(instancia == null) instancia = new ReceptorDeEmpresas();
		
		return instancia;
	}
	
	public void recibirEmpresa(RenglonCSV renglon) {
		if(!existeEmpresa(renglon)) insertarEmpresa(renglon);
		
		else modificarEmpresa(renglon);
	}
	
	private Boolean existeEmpresa(RenglonCSV renglon) {
		try
		{
			return renglon.getEmpresa().getNombre().equals(RepositorioEmpresas.getInstancia().buscarObjeto(renglon.getEmpresa().getNombre()));
		}
		catch(NoExisteObjetoConEseNombreException excepcion)
		{
			return false;
		}
	}
	
	private void insertarEmpresa(RenglonCSV renglon) {
		RepositorioEmpresas.getInstancia().agregarObjeto(renglon.getEmpresa());
	}
	
	private void modificarEmpresa(RenglonCSV renglon) {
		Empresa empresaVieja = RepositorioEmpresas.getInstancia().buscarObjeto(renglon.getEmpresa().getNombre());
		
		renglon.actualizar(empresaVieja);
		
		RepositorioEmpresas.getInstancia().modificarObjeto(empresaVieja);
	}
}
