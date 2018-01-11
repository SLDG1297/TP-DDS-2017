package Archivo.CargaBatchV2;

import Archivo.CargaBatchV2.Excepciones.TieneErroresDeScanException;

public interface ResultadoDeScan {
	EmpresaToken devolverResultado() throws TieneErroresDeScanException;
}
