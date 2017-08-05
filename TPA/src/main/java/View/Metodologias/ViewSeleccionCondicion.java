package View.Metodologias;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Indicadores.Expresion;
import View.Metodologias.VMSeleccionCondicion;

public abstract class ViewSeleccionCondicion extends Window<VMSeleccionCondicion> {

	public ViewSeleccionCondicion(WindowOwner panelPrincipal, VMSeleccionCondicion VMmetodologia) {
		super(panelPrincipal, VMmetodologia);
	}
	
	@Override
	public void createContents(Panel panel) {
		
		this.comienzo(panel);
		this.seleccionIndicador(panel);
		this.seleccionCondicion(panel);
		
	}
	
	public abstract void comienzo(Panel panel);
	
	public void seleccionIndicador(Panel panel) {
	
		new Label(panel).setText("Elegir un indicador");
		new Label(panel); //Espacio
		
		//Selector del indicador a elegir para aplicarle una condicion
		Selector<Expresion> selector = new Selector<Expresion>(panel);
		selector.bindValueToProperty("nombreDeIndicadorElegido");
		selector.bindItemsToProperty("nombresDeIndicadoresExistentes");
		
	}
	
	public void seleccionCondicion(Panel panel) {
	
		new Label(panel); //Espacio
		new Label(panel).setText("Elija la condicion que desea agregar");
		new Label(panel); //Espacio
		
		Button booleana = new Button(panel).setCaption("Mayor o menor a valor en N periodos");
		Button prosummed = new Button(panel).setCaption("Promedio, sumatoria o mediana mayor o menor a un valor");
		Button comportamiento = new Button(panel).setCaption("Comportamiento en N periodos");
		
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
	
	
	
}
