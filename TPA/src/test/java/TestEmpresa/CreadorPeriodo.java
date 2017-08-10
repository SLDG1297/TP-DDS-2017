package TestEmpresa;

import java.util.List;

import Modelo.Empresa.Cuenta;
import Modelo.Empresa.Periodo;

public class CreadorPeriodo {
	public static Periodo crearPeriodo(Integer anio, List<Cuenta> cuentas){
		return new Periodo(anio, cuentas);
	}
}