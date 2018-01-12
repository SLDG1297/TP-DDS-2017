package Archivo.CargaBatchV2.ResultadosDeScan;

import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.Excepciones.TieneErroresDeScanException;

public interface ResultadoDeScan {
	EmpresaToken devolverResultado() throws TieneErroresDeScanException;
}
