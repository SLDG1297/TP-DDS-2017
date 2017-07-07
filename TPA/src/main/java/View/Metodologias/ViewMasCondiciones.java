package View.Metodologias;

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
		
		new Label(panelPrincipal).setText("Elija indicador");
		new Label(panelPrincipal); //Espacio
		
		//Selector del indicador a elegir para aplicarle una condicion
		Selector<Expresion> selector = new Selector<Expresion>(panelPrincipal);
		selector.bindValueToProperty("nombreDeIndicadorElegido");
		selector.bindItemsToProperty("nombresDeIndicadoresExistentes");
		
		new Label(panelPrincipal).setText("Elija la condicion que desea agregar");
		
		Button booleana = new Button(panelPrincipal).setCaption("Mayor o menor a valor en N periodos");
		Button prosummed = new Button(panelPrincipal).setCaption("Promedio, Sumatoria o mediana mayor o menor a un valor");
		Button comportamiento = new Button(panelPrincipal).setCaption("Comportamiento en N periodos");
		
        /*booleana.onClick(() -> {
			
			miMetodologiaBuilder.setNombreMetodologia(this.getModelObject().getNombreMetodologia());
			miMetodologiaBuilder.setIndicadorSeleccionado(this.getModelObject().devolverIndicador());
			new ViewAgregarBooleana(this, new VMAgregarBooleana(miMetodologiaBuilder)).open();
			
		});
        
        prosummed.onClick(() -> {
			
			miMetodologiaBuilder.setNombreMetodologia(this.getModelObject().getNombreMetodologia());
			miMetodologiaBuilder.setIndicadorSeleccionado(this.getModelObject().devolverIndicador());
			//new ViewAgregarIndicador(this, new VMAgregarIndicador(miIndicadorBuilder)).open();
			
		});
        
        comportamiento.onClick(() -> {
			
			miMetodologiaBuilder.setNombreMetodologia(this.getModelObject().getNombreMetodologia());
			miMetodologiaBuilder.setIndicadorSeleccionado(this.getModelObject().devolverIndicador());
			//new ViewAgregarIndicador(this, new VMAgregarIndicador(miIndicadorBuilder)).open();
			
		});
		*/
	}
	
}
