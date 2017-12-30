package Archivo.CargaBatchV2.Analizadores;

import Archivo.CargaBatchV2.AnalizadorDeCargas;
import Archivo.CargaBatchV2.EmpresaToken;
import DB.Excepciones.NoExisteObjetoConEseNombreException;
import DB.Repositorios.RepositorioEmpresas;

public class AnalizadorDeRepositorio extends AnalizadorDeCargas {

	@Override
	public boolean existeLaCarga(EmpresaToken token) {
		try
		{
			return RepositorioEmpresas.getInstancia().buscarObjeto(token.getNombreEmpresa()) != null;
		}
		catch (NoExisteObjetoConEseNombreException excepcion)
		{
			return false;
		}
	}

}
