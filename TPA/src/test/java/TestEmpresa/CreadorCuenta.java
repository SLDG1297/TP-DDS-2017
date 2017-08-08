package TestEmpresa;

import Modelo.Empresa.Cuenta;

public class CreadorCuenta {
	public static Cuenta crearCuenta(String nombre, Integer valor){
		return new Cuenta(nombre, valor);
	}
}
