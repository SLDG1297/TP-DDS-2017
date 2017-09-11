package Factories;

import Modelo.Empresa.Cuenta;

public class FactoryCuenta {
	public static Cuenta crearCuenta(String nombre, int valor) {
		return new Cuenta(nombre, valor);
	}
}
