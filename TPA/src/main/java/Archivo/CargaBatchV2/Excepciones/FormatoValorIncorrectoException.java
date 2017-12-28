package Archivo.CargaBatchV2.Excepciones;

public class FormatoValorIncorrectoException extends FormatoException {
	String valorErroneo;

	public FormatoValorIncorrectoException(String valorErroneo) {
		this.valorErroneo = valorErroneo;
	}

	@Override
	public String explicarFalla() {
		return valorErroneo + " ya que no sigue un formato num�rico para un valor de cuenta.";
	}
}
