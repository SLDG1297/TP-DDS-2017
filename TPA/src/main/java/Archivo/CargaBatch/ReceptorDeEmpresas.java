package Archivo.CargaBatch;

import Archivo.CargaBatch.Excepciones.NoTieneCambiosException;
import DB.Excepciones.NoExisteObjetoConEseNombreException;
import DB.GestorDeCache;
import DB.Repositorios.RepositorioEmpresas;
import Modelo.Empresa.Empresa;

public class ReceptorDeEmpresas {
	public ReceptorDeEmpresas() { }
	
	public void recibirEmpresa(RenglonCSV renglon) {
		try
		{
			modificarEmpresa(renglon);
		}
		catch(NoExisteObjetoConEseNombreException excepcion)
		{
			insertarEmpresa(renglon);
		}
		catch(NoTieneCambiosException excepcion)
		{
			
		}
	}
	
	public void insertarEmpresa(RenglonCSV renglon) {
		RepositorioEmpresas.getInstancia().agregarObjeto(renglon.getEmpresa());
	}
	
	public void modificarEmpresa(RenglonCSV renglon) {
		Empresa empresaVieja = RepositorioEmpresas.getInstancia().buscarObjeto(renglon.getEmpresa().getNombre());
		
		renglon.actualizar(empresaVieja);
		
		RepositorioEmpresas.getInstancia().modificarObjeto(empresaVieja);

		try {
			GestorDeCache.getInstance().eliminarEmpresa(renglon.getEmpresa().getNombre());
		}
		catch (NullPointerException e){

		}


	}
}
