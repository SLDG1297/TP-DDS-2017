package Factories;

import Modelo.Empresa.Empresa;
import Modelo.Metodologias.Metodologia;
import Modelo.Metodologias.Comparadores.*;

public class FactoryComparadores {
	public static ComparadorUnario crearComparadorUnario(Empresa empresa, Metodologia metodologia) {
		return new ComparadorUnario(empresa, metodologia);
	}
	
	public static ComparadorDual crearComparadorDual(Empresa empresa1, Empresa empresa2, Metodologia metodologia) {
		return new ComparadorDual(empresa1, empresa2, metodologia);
	}
}
