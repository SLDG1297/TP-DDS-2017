package Archivo.CargaBatchV2.Scanners;

import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.Excepciones.ScannerException;
import Archivo.CargaBatchV2.ResultadosDeScan.ResultadoDeScan;
import Archivo.CargaBatchV2.ResultadosDeScan.ResultadoNegativo;
import Archivo.CargaBatchV2.ResultadosDeScan.ResultadoPositivo;

public abstract class StringScanner {
	public ResultadoDeScan escanear(String renglon) {
		try
		{
			EmpresaToken token = this.intentarEscanear(renglon);
			
			return new ResultadoPositivo(token);
		}
		catch (ScannerException excepcion)
		{
			return new ResultadoNegativo(renglon, excepcion);
		}
	}

	public abstract EmpresaToken intentarEscanear(String renglon);
}
