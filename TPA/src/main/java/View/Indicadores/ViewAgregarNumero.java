package View.Indicadores;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Indicadores.Expresion;

public class ViewAgregarNumero extends ViewAgregar {
	
	public ViewAgregarNumero(WindowOwner panelPrincipal, VMAgregarNumero vmNumero) {
		super(panelPrincipal, vmNumero);
	}


	
	public void cuerpo(Panel x){
		
		new Label(x).setText("Escriba el nuevo operando numero");
		new Label(x); //Espacio
		

		new NumericField(x).bindValueToProperty("numeroElegido");
		new Label(x); //Espacio
		
	}

	public String cadena(){
		return this.getModelObject().devolverStringDeNumero();
	}
	
	public Expresion operacion(){
		return this.getModelObject().devolverNumero();
	}
}