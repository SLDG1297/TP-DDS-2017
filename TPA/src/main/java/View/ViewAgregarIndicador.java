package View;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Expresion;

public class ViewAgregarIndicador extends Window<VMAgregarIndicador> {
	
	public ViewAgregarIndicador(WindowOwner panelPrincipal, VMAgregarIndicador VMindicador) {
		super(panelPrincipal, VMindicador);
	}

	@Override
	public void createContents(Panel panelAgregarIndicador) {
		
		this.setTitle("Nuevo operando indicador");
		
		new Label(panelAgregarIndicador).setText("Elija indicador");
		new Label(panelAgregarIndicador); //Espacio
		
		Selector<Expresion> selector = new Selector<Expresion>(panelAgregarIndicador);
		selector.allowNull(true);
		selector.bindValueToProperty("nombreDeIndicadorElegido");
		selector.bindItemsToProperty("nombresDeIndicadoresExistentes");
		
		new Label(panelAgregarIndicador).setText("Elija accion para el operando indicador elegido");
		new Label(panelAgregarIndicador); //Espacio
		
		new Button(panelAgregarIndicador).setCaption("Sumar");
		new Button(panelAgregarIndicador).setCaption("Restar");
		new Button(panelAgregarIndicador).setCaption("Multiplicar");
		new Button(panelAgregarIndicador).setCaption("Dividir");
		
		//.onClick(() -> new ViewAgregarIndicador(this, new VMAgregarIndicador()).open());
		

	}
	

}
