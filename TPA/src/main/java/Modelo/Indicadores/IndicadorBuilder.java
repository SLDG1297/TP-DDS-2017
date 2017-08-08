package Modelo.Indicadores;

public class IndicadorBuilder {

	String nombreIndicador;
	Expresion operandoAnterior;
	
	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
		this.operandoAnterior = null;
	}
	
	public Expresion getOperandoAnterior() {
		return operandoAnterior;
	}

	public void setOperandoAnterior(Expresion operandoAnterior) {
		this.operandoAnterior = operandoAnterior;
	}
	
	public void crearIndicador(Expresion expresion){ 
		IndicadoresRepository.getInstancia().agregarIndicador(new Indicador(nombreIndicador,expresion));
	}
}
