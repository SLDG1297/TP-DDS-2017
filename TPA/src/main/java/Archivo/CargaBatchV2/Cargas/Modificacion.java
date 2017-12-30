package Archivo.CargaBatchV2.Cargas;

import Archivo.CargaBatchV2.Carga;
import Archivo.CargaBatchV2.EmpresaToken;
import DB.Repositorios.RepositorioEmpresas;
import Modelo.Empresa.Empresa;

public class Modificacion extends Carga {
	public Modificacion(EmpresaToken empresa) {
		super(empresa);
	}

	@Override
	public void efectuarse() {
		Empresa empresaVieja = RepositorioEmpresas.getInstancia().buscarObjeto(this.getEmpresa().getNombreEmpresa());
		
		empresaVieja.actualizar(this.getEmpresa());
	}

}
