package Archivo.CargaBatch.Cargadores;

import Archivo.CargaBatch.EmpresaToken;
import DB.GestorDeCache;

public class CargadorDeRespositorioNotificador extends CargadorDeRepositorio {
	
	@Override
	public void realizarModificacion(EmpresaToken token) {
		super.realizarModificacion(token);
		
		// Avisenme qu� l�nea pongo
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
