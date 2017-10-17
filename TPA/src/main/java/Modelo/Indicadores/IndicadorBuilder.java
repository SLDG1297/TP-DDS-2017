package Modelo.Indicadores;

import DB.Repositorios.RepositorioIndicadores;
import Modelo.Excepciones.Indicadores.IndicadorSinNombreException;

public class IndicadorBuilder {

	String nombreIndicador;
	Expresion operandoAnterior;
	
	public void setNombreIndicador(String nombreIndicador) {
		if(nombreIndicador.isEmpty()) throw new IndicadorSinNombreException();
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
		RepositorioIndicadores.getInstancia().agregarObjeto(indicadorCreado);
		
		return indicadorCreado;
	}
	
	public String imprimirFormula() {
		if(operandoAnterior == null) {
			return "";
		}
		return operandoAnterior.imprimirFormula();
	}
	
}
