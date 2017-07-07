package View.Metodologias;

import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import Modelo.Indicadores.CadenaActualDeMiIndicador;
import Modelo.Indicadores.IndicadoresRepository;
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
