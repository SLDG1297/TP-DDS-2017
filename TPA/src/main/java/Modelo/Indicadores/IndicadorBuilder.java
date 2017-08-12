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
	
	public Indicador crearIndicador(Expresion expresion){ 
		Indicador indicadorCreado;
		indicadorCreado = new Indicador(nombreIndicador, expresion);
		IndicadoresRepository.getInstancia().agregarIndicador(indicadorCreado);
		
		return indicadorCreado;
	}
	
	public String imprimirFormula() {
		return operandoAnterior.imprimirFormula();
	}
	
}
