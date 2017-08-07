package TestEmpresa;

import java.util.ArrayList;
import java.util.List;

import Modelo.Empresa.Cuenta;

public class UtilsCuenta {
	public static Cuenta crearCuenta(String nombre, Integer valor){
		return new Cuenta(nombre, valor);
	}
	
	public static List<Cuenta> crearListaCuentas(){
		return new ArrayList<Cuenta>();
	}
}
