package Archivo.CargaBatch;

import java.io.IOException;

import Archivo.CargaBatch.Excepciones.NoTieneCambiosException;
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
	
	public void dejarPasar(String ruta) throws IOException {
		CompiladorCSV.instanciar().compilarEmpresas(ruta).stream().forEach(r -> recibirEmpresa(r));
	}
	
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
	}
}
