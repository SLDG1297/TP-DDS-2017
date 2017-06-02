package Modelo;

import java.math.BigDecimal;

public class IndicadorBuilder {

	String nombreIndicador;
	Operacion operandoAnterior = new Suma(new Numero(new BigDecimal(0)));
	IndicadoresRepository repositorio = IndicadoresRepository.getInstancia();
	
	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
	}
	
	public Operacion getOperandoAnterior() {
		return operandoAnterior;
	}

	public void setOperandoAnterior(Operacion operandoAnterior) {
		this.operandoAnterior = operandoAnterior;
	}
	
	public void crearIndicador(Expresion formula){ //Tiene que ser Expresion formula o Operacion formula?
		this.repositorio.agregarIndicador(new Indicador(nombreIndicador,formula));
	}
}
