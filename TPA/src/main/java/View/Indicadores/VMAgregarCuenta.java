package View.Indicadores;

import org.uqbar.commons.utils.Observable;
import Modelo.Empresa.Cuenta;
import Modelo.Indicadores.CadenaActualDeMiIndicador;
import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.IndicadorBuilder;



@Observable
public class VMAgregarCuenta extends VMAgregar{

	IndicadorBuilder miIndicadorBuilder;
	String cuentaElegida;

	String miCadena = CadenaActualDeMiIndicador.instanciar().mostrarCadenaActual();

	public VMAgregarCuenta(IndicadorBuilder indicadorBuilder) {
		super(indicadorBuilder);
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
		return miCadena;
	}

	public void setMiCadena(String miCadena) {
		this.miCadena = miCadena;
	}

}