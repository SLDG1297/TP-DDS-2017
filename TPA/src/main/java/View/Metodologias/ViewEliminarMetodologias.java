package View.Metodologias;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Metodologias.Metodologia;

public class ViewEliminarMetodologias extends Window<VMEliminarMetodologias> {
	
		public ViewEliminarMetodologias(WindowOwner owner, VMEliminarMetodologias model) {
			super(owner, model);
		}

		@Override
		public void createContents(Panel panelPrincipal) {
			
			this.setTitle("Eliminar metodologia");
			
			new Label(panelPrincipal).setText("Seleccione la metodologia a eliminar:");
			new Label(panelPrincipal); //Espacio
			
			// Selector de las metodologias proximas a ser desaparecidas
			Selector<Metodologia> selector = new Selector<Metodologia>(panelPrincipal);
			selector.bindValueToProperty("nombreDeMetodologiaElegida");
			selector.bindItemsToProperty("nombresDeMetodologiasExistentes");
			new Label(panelPrincipal); //Espacio
			
			Button destruir = new Button(panelPrincipal).setCaption("Eliminar metodologia");
									
			destruir.onClick(() -> {
				this.getModelObject().destruirMetodologiaSeleccionada();
			});
			
		}
}
