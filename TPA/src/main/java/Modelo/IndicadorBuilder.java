package Modelo;

public class IndicadorBuilder {

	String nombreIndicador;
	
	public Operacion getMultOrDivOperation(String operando1, String operando2, String operador) {
		if(operador.equals("*"))return new Multiplicacion(operando1,operando2);
		else return new Division(operando1,operando2);
	}
	
	public Operacion getSumOrResOperation(Operacion operacion1, Operacion operacion2, String operador){
		if(operador.equals("+"))return new Suma(operacion1, operacion2);
		else return new Resta(operacion1,operacion2);
	}
	
	public void crearIndicador(Operacion formula){
		IndicadoresRepository.agregarIndicador(new Indicador(nombreIndicador,formula));
	}
	
	public String getNombreIndicador() {
		return nombreIndicador;
	}

	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
	}
}
