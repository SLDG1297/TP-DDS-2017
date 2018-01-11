package Archivo.CargaBatchV2.ResultadosDeScan;

import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.ResultadoDeScan;
import Archivo.CargaBatchV2.Excepciones.ScannerException;
import Archivo.CargaBatchV2.Excepciones.TieneErroresDeScanException;

public class ResultadoNegativo implements ResultadoDeScan {
	private String renglon;
	private ScannerException excepcion;

	public ResultadoNegativo(String renglon, ScannerException excepcion) {
		this.renglon = renglon;
		this.excepcion = excepcion;
	}

	public String getRenglon() {
		return renglon;
	}

	public void setRenglon(String renglon) {
		this.renglon = renglon;
	}

	public ScannerException getExcepcion() {
		return excepcion;
	}

	public void setExcepcion(ScannerException excepcion) {
		this.excepcion = excepcion;
	}

	@Override
	public EmpresaToken devolverResultado() throws TieneErroresDeScanException {
		throw new TieneErroresDeScanException();
	}
}
