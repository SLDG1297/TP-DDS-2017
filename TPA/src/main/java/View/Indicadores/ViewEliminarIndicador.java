package View.Indicadores;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Indicadores.Indicador;

public class ViewEliminarIndicador extends Window<VMEliminarIndicador>{

	public ViewEliminarIndicador(WindowOwner owner, VMEliminarIndicador model) {
		super(owner, model);
	}
	
	@Override
	public void createContents(Panel panelEliminar) {
		this.setTitle("Eliminar Indicador");
		
		 new Label(panelEliminar); //Para dejar espacio
			new Label(panelEliminar).setText("Elegir indicador");
			new Label(panelEliminar); //Para dejar espacio
		    
			//Aca se elige el indicador
			Selector<Indicador> selectorIndicador = new Selector<Indicador>(panelEliminar);
			selectorIndicador.bindValueToProperty("nombreIndicador");
			selectorIndicador.bindItemsToProperty("listaDeNombresDeIndicador");
			
			Button elegirIndicador = new Button(panelEliminar);
			elegirIndicador.setCaption("Elegir Indicador");	
			elegirIndicador.onClick(()-> this.getModelObject().buscarIndicadorSeleccionado());
			
			new Label(panelEliminar); //Para dejar espacio
			
			Button eliminarIndicador = new Button(panelEliminar);
			eliminarIndicador.setCaption("Eliminar");	
			eliminarIndicador.onClick(()-> this.getModelObject().x());
	}

}
