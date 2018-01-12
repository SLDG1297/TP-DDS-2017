package Archivo.CargaBatchV2.ResultadosDeScan;

import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.Excepciones.TieneErroresDeScanException;

public class ResultadoPositivo implements ResultadoDeScan {
	private EmpresaToken token;
	
	public ResultadoPositivo(EmpresaToken token) {
		this.token = token;
	}

	@Override
	public EmpresaToken devolverResultado() throws TieneErroresDeScanException {
		return this.token;
	}

}
