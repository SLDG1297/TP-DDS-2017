package Archivo.CargaBatchV2.Cargadores;

import Archivo.CargaBatchV2.Cargador;
import Archivo.CargaBatchV2.EmpresaToken;
import DB.Repositorios.RepositorioEmpresas;
import Modelo.Empresa.Empresa;

public class CargadorDeRepositorio extends Cargador {
	@Override
	public boolean existeLaCarga(EmpresaToken token) {
		return RepositorioEmpresas.getInstancia().existeObjeto(token.getNombreEmpresa());
	}

	@Override
	public void realizarAlta(EmpresaToken token) {
		Empresa empresaNueva = token.generarEmpresa();
		
		RepositorioEmpresas.getInstancia().agregarObjeto(empresaNueva);
	}

	@Override
	public void realizarModificacion(EmpresaToken token) {
		Empresa empresaVieja = RepositorioEmpresas.getInstancia().buscarObjeto(token.getNombreEmpresa());
		
		empresaVieja.actualizar(token);
	}

}
