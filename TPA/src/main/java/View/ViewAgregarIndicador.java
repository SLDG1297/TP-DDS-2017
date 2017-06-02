package View;

import java.awt.Color;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Division;
import Modelo.Expresion;
import Modelo.Multiplicacion;
import Modelo.Resta;
import Modelo.Suma;

public class ViewAgregarIndicador extends Window<VMAgregarIndicador> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewAgregarIndicador(WindowOwner panelPrincipal, VMAgregarIndicador VMindicador) {
		super(panelPrincipal, VMindicador);
	}

	@Override
	public void createContents(Panel panelAgregarIndicador) {
		
		this.setTitle("Nuevo operando indicador");
		
		new Label(panelAgregarIndicador).setText("Estado actual del indicador:");
		new Label(panelAgregarIndicador).setBackground(Color.WHITE).bindValueToProperty("miCadena");
		new Label(panelAgregarIndicador); // Espacio
		
		new Label(panelAgregarIndicador).setText("Elija indicador");
		new Label(panelAgregarIndicador); //Espacio
		
		Selector<Expresion> selector = new Selector<Expresion>(panelAgregarIndicador);
		selector.bindValueToProperty("nombreDeIndicadorElegido");
		selector.bindItemsToProperty("nombresDeIndicadoresExistentes");
		
		new Label(panelAgregarIndicador).setText("Elija accion para el operando indicador elegido");
		new Label(panelAgregarIndicador); //Espacio
		
		Button suma = new Button(panelAgregarIndicador);
		Button resta = new Button(panelAgregarIndicador);
		Button multiplicar = new Button(panelAgregarIndicador);
		Button dividir = new Button(panelAgregarIndicador);
		new Label(panelAgregarIndicador); //Espacio
		
		Button crear = new Button(panelAgregarIndicador);
		
		// Habria q hacer setter cada vez que hay get del builder
		
		crear.onClick(() -> this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverIndicador()));
		crear.onClick(() -> this.getModelObject().miIndicadorBuilder.crearIndicador());
		
		suma.setCaption("Sumar").onClick(() -> this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverIndicador()));
		suma.onClick(() -> this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Suma(this.getModelObject().miIndicadorBuilder.getOperandoAnterior())));
		suma.onClick(() -> new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open());
		
		resta.setCaption("Resta").onClick(() -> this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverIndicador()));
		resta.onClick(() -> this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Resta(this.getModelObject().miIndicadorBuilder.getOperandoAnterior())));
		resta.onClick(() -> new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open());
		
		multiplicar.setCaption("Multiplicar").onClick(() -> this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverIndicador()));
		multiplicar.onClick(() -> this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Multiplicacion(this.getModelObject().miIndicadorBuilder.getOperandoAnterior())));
		multiplicar.onClick(() -> new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open());
		

		dividir.setCaption("Dividir").onClick(() -> this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverIndicador()));
		dividir.onClick(() -> this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Division(this.getModelObject().miIndicadorBuilder.getOperandoAnterior())));
		dividir.onClick(() -> new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open());

		
		new Label(panelAgregarIndicador); //Espacio
		
		crear.setCaption("Crear Indicador");
			
		
	}
	

}
