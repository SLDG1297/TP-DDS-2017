package View.Indicadores;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Indicadores.Expresion;

public class ViewAgregarIndicador extends ViewAgregar {
	
	public ViewAgregarIndicador(WindowOwner panelPrincipal, VMAgregarIndicador VMindicador) {
		super(panelPrincipal, VMindicador);
	}
	


	public void cuerpo(Panel x){
		
		new Label(x).setText("Elija indicador");
		new Label(x); //Espacio
		
		Selector<Expresion> selector = new Selector<Expresion>(x);
		selector.bindValueToProperty("nombreDeIndicadorElegido");
		selector.bindItemsToProperty("nombresDeIndicadoresExistentes");
		
		new Label(x).setText("Elija accion para el operando indicador elegido");
		new Label(x); //Espacio
		
	}

	public String cadena(){
		return this.getModelObject().getNombreDeIndicadorElegido();
	}
	
	public Expresion operacion(){
		return this.getModelObject().devolverIndicador();
	}

}
