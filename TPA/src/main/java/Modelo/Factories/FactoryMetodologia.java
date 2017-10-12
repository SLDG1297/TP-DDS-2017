package Modelo.Factories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Modelo.Metodologias.Metodologia;
import Modelo.Metodologias.Condiciones.Condiciones;

public class FactoryMetodologia {
	public static Metodologia crearMetodologia(String nombre, Condiciones... condiciones) {
		List<Condiciones> listaCondiciones = new ArrayList<Condiciones>();
		listaCondiciones.addAll(Arrays.asList(condiciones));
		
		return new Metodologia(nombre, listaCondiciones);
	}
}
