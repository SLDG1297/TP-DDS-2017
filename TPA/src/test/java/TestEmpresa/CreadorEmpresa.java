package TestEmpresa;

import java.util.List;

import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;

public class CreadorEmpresa {
	public static Empresa crearEmpresa(String nombre, List<Periodo> periodos){
		return new Empresa(nombre, periodos);
	}
}
