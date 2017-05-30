package Indicadores;

import java.util.List;
import com.ibm.icu.math.BigDecimal;

import Modelo.Cuenta;
import Modelo.Empresa;

public class Indicador {

	private String nombre;
	private Operacion formula;
	
	public Indicador(String nombre, Operacion formula) {
		this.nombre = nombre;
		this.formula = formula;
	}
		
	public BigDecimal evaluar(Empresa empresa, int periodo){
	List<Cuenta> cuentas = empresa.obtenerCuentasEnPeriodo(periodo);
	return formula.aplicar(cuentas);
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Operacion getFormula() {
		return formula;
	}

	public void setFormula(Operacion formula) {
		this.formula = formula;
	}
}
