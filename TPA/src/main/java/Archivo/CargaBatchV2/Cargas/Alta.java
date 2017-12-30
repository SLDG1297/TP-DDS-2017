package Archivo.CargaBatchV2.Cargas;

import Archivo.CargaBatchV2.Carga;
import Archivo.CargaBatchV2.EmpresaToken;
import DB.Repositorios.RepositorioEmpresas;

public class Alta extends Carga {
	public Alta(EmpresaToken empresa) {
		super(empresa);
	}

	@Override
	public void efectuarse() {
		RepositorioEmpresas.getInstancia().agregarObjeto(this.getEmpresa().generarEmpresa());
	}

}
