package View.Metodologias;

import java.awt.Color;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Indicadores.Expresion;
import Modelo.Metodologias.MetodologiaBuilder;

public class ViewMasCondiciones extends Window<VMMasCondiciones>  {
	
	public ViewMasCondiciones(WindowOwner owner, VMMasCondiciones model) {
		super(owner, model);
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		
		new Label(panelPrincipal).setText("Condiciones actuales de la metodologia:");
		new Label(panelPrincipal).setBackground(Color.WHITE).bindValueToProperty("miCadena");
		new Label(panelPrincipal); //Espacio
		
		new Label(panelPrincipal).setText("Elegir un indicador");
		new Label(panelPrincipal); //Espacio
		
		//Selector del indicador a elegir para aplicarle una condicion
		Selector<Expresion> selector = new Selector<Expresion>(panelPrincipal);
		selector.bindValueToProperty("nombreDeIndicadorElegido");
		selector.bindItemsToProperty("nombresDeIndicadoresExistentes");
		
		new Label(panelPrincipal).setText("Elija la condicion que desea agregar");
		
		Button booleana = new Button(panelPrincipal).setCaption("Mayor o menor a valor en N periodos");
		Button prosummed = new Button(panelPrincipal).setCaption("Promedio, Sumatoria o mediana mayor o menor a un valor");
		Button comportamiento = new Button(panelPrincipal).setCaption("Comportamiento en N periodos");
		
		booleana.onClick(() -> {
				
		    this.getModelObject().iniciarBuilder();
			new ViewAgregarBooleana(this, new VMAgregarBooleana(this.getModelObject().getMiMetodologiaBuilder())).open();
				
		});
	        
	    prosummed.onClick(() -> {
				
		    this.getModelObject().iniciarBuilder();
			new ViewAgregarBooleana(this, new VMAgregarBooleana(this.getModelObject().getMiMetodologiaBuilder())).open();
				
	    });
	       
	    comportamiento.onClick(() -> {
				
		    this.getModelObject().iniciarBuilder();
			new ViewAgregarBooleana(this, new VMAgregarBooleana(this.getModelObject().getMiMetodologiaBuilder())).open();
				
		});
	}
	
}
