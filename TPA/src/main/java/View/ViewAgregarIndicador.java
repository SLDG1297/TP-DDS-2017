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
		
		Button suma = new Button(panelAgregarIndicador);
		Button resta = new Button(panelAgregarIndicador);
		Button multiplicar = new Button(panelAgregarIndicador);
		Button dividir = new Button(panelAgregarIndicador);
		Button crear = new Button(panelAgregarIndicador);
		
		suma.setCaption("Sumar").onClick(() -> this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().tomarIndicador()));
		suma.onClick(() -> new ViewSuma(this, new VMIngresarOperando()).open()); 
		
		resta.setCaption("Resta");
		multiplicar.setCaption("Multiplicar");
		dividir.setCaption("Dividir");
		
		new Label(panelAgregarIndicador); //Espacio
		
		crear.setCaption("Crear Indicador");
			
		
	}
	

}
