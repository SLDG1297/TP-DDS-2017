package Archivo.CargaBatchV2.Excepciones.DeFormato;

import Archivo.CargaBatchV2.Excepciones.FormatoException;

public class FormatoAnioIncorrectoException extends FormatoException {
	String anioErroneo;

	public FormatoAnioIncorrectoException(String anioErroneo) {
		this.anioErroneo = anioErroneo;
	}

	@Override
	public String explicarFalla() {
		return anioErroneo + " ya que no sigue un formato numérico para un año.";
	}
}
