package Archivo.CargaBatchV2.Cargadores;

import Archivo.CargaBatchV2.EmpresaToken;
import DB.Repositorios.RepositorioEmpresas;

public class CargadorDeRepositorio extends Cargador {
	@Override
	public boolean existeLaCarga(EmpresaToken token) {
		return RepositorioEmpresas.getInstancia().existeObjeto(token.getNombreEmpresa());
	}

	@Override
	public void realizarAlta(EmpresaToken token) {
		RepositorioEmpresas.getInstancia().agregarObjeto(token.generarEmpresa());
	}

	@Override
	public void realizarModificacion(EmpresaToken token) {
		RepositorioEmpresas.getInstancia().modificarEmpresa(token);
	}

}
