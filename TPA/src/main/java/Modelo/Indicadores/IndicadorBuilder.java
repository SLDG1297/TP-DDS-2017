package Modelo.Indicadores;

import java.math.BigDecimal;

public class IndicadorBuilder {

	String nombreIndicador;
	Expresion operandoAnterior = null;
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
	
	public void crearIndicador(){ 
		this.repositorio.agregarIndicador(new Indicador(nombreIndicador,operandoAnterior));
	}
}
