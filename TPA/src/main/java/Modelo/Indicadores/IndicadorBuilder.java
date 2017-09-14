package Modelo.Indicadores;

import DB.Repositorios.RepositorioIndicadores;

public class IndicadorBuilder {

	String nombreIndicador;
	Expresiones operandoAnterior;
	
	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
		this.operandoAnterior = null;
	}
	
	public Expresiones getOperandoAnterior() {
		return operandoAnterior;
	}

	public void setOperandoAnterior(Expresiones operandoAnterior) {
		this.operandoAnterior = operandoAnterior;
	}
	
	public Indicador crearIndicador(Expresiones expresion){ 
		Indicador indicadorCreado;
		indicadorCreado = new Indicador(nombreIndicador, expresion);
		RepositorioIndicadores.getInstancia().agregarObjeto(indicadorCreado, "DB");
		
		return indicadorCreado;
	}
	
	public String imprimirFormula() {
		if(operandoAnterior == null) {
			return "";
		}
		return operandoAnterior.imprimirFormula();
	}
	
}
