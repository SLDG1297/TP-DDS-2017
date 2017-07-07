package Modelo.Metodologias.Condiciones;

import java.math.BigDecimal;

import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Condiciones.Booleana;

public class MenorAEnPeriodos extends Booleana{

	public MenorAEnPeriodos(Indicador indicador, BigDecimal valor, int anios) {
		super(indicador, valor, anios);
	}

	@Override
	protected int booleano() {
		return -1;
	}
	
	@Override
	public String mostrarCadena() {
		return "El indicador " + indicador.getNombre() + " es menor a " + valor.toString() + " en " + String.valueOf(anios) + " años";
	}
	
	
}
