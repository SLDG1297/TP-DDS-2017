package Archivo.CargaBatch.Cargadores;

import Archivo.CargaBatch.EmpresaToken;
import DB.GestorDeCache;

public class CargadorDeRespositorioNotificador extends CargadorDeRepositorio {
	
	@Override
	public void realizarModificacion(EmpresaToken token) {
		super.realizarModificacion(token);
		
		// Avisenme qué línea pongo
		/**
		//observerEmpresas.notificarObservadores();
  		try
  		{
  			GestorDeCache.getInstance().eliminarEmpresa(token.getNombreEmpresa());
  		}
		catch (NullPointerException e){
	
		}
		**/
	}
}
