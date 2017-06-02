package View;

import java.math.BigDecimal;

import org.uqbar.commons.utils.Observable;

import Modelo.CadenaActualDeMiIndicador;
import Modelo.Cuenta;
import Modelo.Expresion;
import Modelo.Indicador;
import Modelo.IndicadorBuilder;
import Modelo.IndicadoresRepository;
import Modelo.Suma;



@Observable
public class VMAgregarCuenta {

	IndicadorBuilder miIndicadorBuilder;
	String cuentaElegida;

	public VMAgregarCuenta(IndicadorBuilder indicadorBuilder) {
		miIndicadorBuilder = indicadorBuilder;
	}

	public IndicadorBuilder getMiIndicadorBuilder() {
		return miIndicadorBuilder;
	}

	public void setMiIndicadorBuilder(IndicadorBuilder miIndicadorBuilder) {
		this.miIndicadorBuilder = miIndicadorBuilder;
	}

	public String getCuentaElegida() {
		return cuentaElegida;
	}

	public void setCuentaElegida(String cuentaElegida) {
		this.cuentaElegida = cuentaElegida;
	}

	public Expresion devolverCuenta() {

		Cuenta cuenta = new Cuenta(cuentaElegida);
		return cuenta;
	}
	
	public String getMiCadena() {
		return CadenaActualDeMiIndicador.instanciar().mostrarCadenaActual();
	}

	/*
	public Object realizarSuma() {

		
		miIndicadorBuilder.getOperandoAnterior().addOperando(this.devolverCuenta());
		miIndicadorBuilder.setOperandoAnterior(new Suma(miIndicadorBuilder.getOperandoAnterior()));
		
		
		return null;
	}
	 */

}