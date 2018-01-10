package Archivo.CargaBatchV2.Excepciones.DeFormato;

import Archivo.CargaBatchV2.Excepciones.FormatoException;

public class FormatoValorIncorrectoException extends FormatoException {
	String valorErroneo;

	public FormatoValorIncorrectoException(String valorErroneo) {
		this.valorErroneo = valorErroneo;
	}

	@Override
	public String explicacionDelFallo() {
		return "El campo " + valorErroneo + " no sigue un formato numérico para un valor de cuenta.";
	}
}
