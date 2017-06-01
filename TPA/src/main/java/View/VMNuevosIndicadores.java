package View;

import java.util.List;
import org.uqbar.commons.utils.Observable;
import Modelo.BolsaDeEmpresas;
import Modelo.Empresa;

@Observable
public class VMNuevosIndicadores {
	
	public String nombreDelIndicador;
 
	
	//Constructor
	public VMNuevosIndicadores() {
		super();
		
		
	}


	public String getNombreDelIndicador() {
		return nombreDelIndicador;
	}


	public void setNombreDelIndicador(String nombreDelIndicador) {
		this.nombreDelIndicador = nombreDelIndicador;
	}
	
}