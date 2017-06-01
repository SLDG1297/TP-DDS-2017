package Modelo;

import java.math.BigDecimal;

public class IndicadorBuilder {

	String nombreIndicador;
	Expresion operandoAnterior;
	IndicadoresRepository repositorio = IndicadoresRepository.getInstancia();

	
	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
	}
	
	public Expresion getOperandoAnterior() {
		return operandoAnterior;
	}

	public void setOperandoAnterior(Expresion operandoAnterior) {
		this.operandoAnterior = operandoAnterior;
	}
	
	public void crearIndicador(Expresion formula){
		this.repositorio.agregarIndicador(new Indicador(nombreIndicador,formula));
	}
}
