package Factories;

import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.Indicador;

public class FactoryIndicador {
	public static Indicador crearIndicador(String nombre, Expresion expresion) {
		return new Indicador(nombre, expresion);
	}
}
