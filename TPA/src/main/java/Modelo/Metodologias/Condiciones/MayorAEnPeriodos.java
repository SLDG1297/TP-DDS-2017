package Modelo.Metodologias.Condiciones;

import java.math.BigDecimal;

import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Condiciones.Booleana;

public class MayorAEnPeriodos extends Booleana {

	public MayorAEnPeriodos(Indicador indicador, BigDecimal valor, int anios) {
		super(indicador, valor, anios);
	}

	@Override
	protected int booleano() {
		return 1;
	}
	
	@Override
	public String mostrarCadena() {
		return "El indicador " + indicador.getNombre() + " es mayor a " + valor.toString() + " en " + String.valueOf(anios) + " años";
	}


}
