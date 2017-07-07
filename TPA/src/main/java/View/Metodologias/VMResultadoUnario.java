package View.Metodologias;

import org.uqbar.commons.utils.Observable;


@Observable
public class VMResultadoUnario {
	
	public boolean resultado;
	
	public VMResultadoUnario(boolean resultado){
		super();
		this.resultado = resultado;
	}
	
	public String darResultado(){
		
		if (resultado) {
			
			return "Evaluacion positiva";
		}
		
		else return "Evaluacion negativa";
		
	}
	
	
	public boolean isResultado() {
		return resultado;
	}

	public void setResultado(boolean resultado) {
		this.resultado = resultado;
	}
	
	
}