package View.Metodologias;

import org.uqbar.commons.utils.Observable;
import Modelo.Metodologias.Metodologia;

@Observable
public class VMMetodologiaCreada {
	Metodologia miMetodologia;

	public VMMetodologiaCreada(Metodologia metodologia) {
		this.miMetodologia = metodologia;
	}
	
	public String getMiCadena() {
		return miMetodologia.mostrarCadena();
	}
}
