package Modelo.Metodologias.Condiciones;

import java.math.BigDecimal;

import Modelo.Indicadores.Indicador;

public class PromedioMenorA extends Promedio {

	public PromedioMenorA(Indicador indicador, BigDecimal valor) {
		super(indicador, valor);
	}
	
	@Override
	protected int booleano() {
		return -1;
	}
	
	@Override
	public String mostrarCadena() {
		return "El indicador " + indicador.getNombre() + " tiene un promedio menor a " + valor.toString();
	}
}
