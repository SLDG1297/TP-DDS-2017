package Archivo.CargaBatch;

import DB.Excepciones.NoExisteObjetoConEseNombreException;
import DB.Repositorios.RepositorioEmpresas;

public class ReceptorDeEmpresas {
	private static ReceptorDeEmpresas instancia = null;
	
	private ReceptorDeEmpresas() { }
	
	public static ReceptorDeEmpresas instanciar() {
		if(instancia == null) instancia = new ReceptorDeEmpresas();
		
		return instancia;
	}
	
	public void insertarEmpresa(RenglonCSV renglon) {
		try
		{
			RepositorioEmpresas.getInstancia().buscarObjeto(renglon.getEmpresa().getNombre());
		}
		catch(NoExisteObjetoConEseNombreException excepcion)
		{
			RepositorioEmpresas.getInstancia().agregarObjeto(renglon.getEmpresa());
		}
	}
}
