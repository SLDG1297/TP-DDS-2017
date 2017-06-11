package View.Indicadores;

import org.uqbar.commons.utils.Observable;

@Observable
public class VMNuevosIndicadores {

	public String nombreDelIndicador;

	public VMNuevosIndicadores() {
		super();

	}

	public String getNombreDelIndicador() {
		return nombreDelIndicador;
	}

	public void setNombreDelIndicador(String nombreDelIndicador) {
		this.nombreDelIndicador = nombreDelIndicador;
	}

}