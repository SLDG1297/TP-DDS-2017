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

public class ViewCreacion extends ViewSeleccionCondicion {
	
	MetodologiaBuilder miMetodologiaBuilder;
	
	public ViewCreacion(WindowOwner owner, VMCreacion model) {
		super(owner, model);
		miMetodologiaBuilder = new MetodologiaBuilder();
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		
        this.setTitle("Nueva metodologia");
		
		new Label(panelPrincipal).setText("Nombre de la nueva metodologia");
		new Label(panelPrincipal); //Espacio
		
		new TextBox(panelPrincipal).bindValueToProperty("nombreMetodologia");
		new Label(panelPrincipal); //Espacio
		
		new Label(panelPrincipal).setText("Elegir un indicador");
		new Label(panelPrincipal); //Espacio
		
		//Selector del indicador a elegir para aplicarle una condicion
		Selector<Expresion> selector = new Selector<Expresion>(panelPrincipal);
		selector.bindValueToProperty("nombreDeIndicadorElegido");
		selector.bindItemsToProperty("nombresDeIndicadoresExistentes");
		
		new Label(panelPrincipal); //Espacio
		new Label(panelPrincipal).setText("Elija la condicion que desea agregar");
		new Label(panelPrincipal); //Espacio
		
		Button booleana = new Button(panelPrincipal).setCaption("Mayor o menor a valor en N periodos");
		Button prosummed = new Button(panelPrincipal).setCaption("Promedio, sumatoria o mediana mayor o menor a un valor");
		Button comportamiento = new Button(panelPrincipal).setCaption("Comportamiento en N periodos");
		
        booleana.onClick(() -> {
			
			miMetodologiaBuilder.setNombreMetodologia(this.getModelObject().getNombreMetodologia());
			miMetodologiaBuilder.setIndicadorSeleccionado(this.getModelObject().devolverIndicador());
			new ViewAgregarBooleana(this, new VMAgregarBooleana(miMetodologiaBuilder)).open();
			
		});
        
        prosummed.onClick(() -> {
			
			miMetodologiaBuilder.setNombreMetodologia(this.getModelObject().getNombreMetodologia());
			miMetodologiaBuilder.setIndicadorSeleccionado(this.getModelObject().devolverIndicador());
			new ViewAgregarPromedioSumatoriaMediana(this, new VMAgregarPromedioSumatoriaMediana(miMetodologiaBuilder)).open();
			
		});
        
        comportamiento.onClick(() -> {
			
			miMetodologiaBuilder.setNombreMetodologia(this.getModelObject().getNombreMetodologia());
			miMetodologiaBuilder.setIndicadorSeleccionado(this.getModelObject().devolverIndicador());
			new ViewAgregarComportamiento(this, new VMAgregarComportamiento(miMetodologiaBuilder)).open();
			
		});
		
	}

	@Override
	public void comienzo(Panel panel) {
		
        this.setTitle("Nueva metodologia");
		
		new Label(panel).setText("Nombre de la nueva metodologia");
		new Label(panel); //Espacio
		
		new TextBox(panel).bindValueToProperty("nombreMetodologia");
		new Label(panel); //Espacio
		
	}
	
	
	
}
