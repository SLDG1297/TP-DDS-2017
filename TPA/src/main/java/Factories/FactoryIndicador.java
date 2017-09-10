package Factories;

import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.Expresiones;
import Modelo.Indicadores.Indicador;

public class FactoryIndicador {
	public static Indicador crearIndicador(String nombre, Expresiones expresion) {
		return new Indicador(nombre, expresion);
	}
}
