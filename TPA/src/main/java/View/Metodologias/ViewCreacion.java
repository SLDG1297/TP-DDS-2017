package View.Metodologias;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;

public class ViewCreacion extends ViewSeleccionCondicion {
	
	public ViewCreacion(WindowOwner owner, VMSeleccionCondicion model) {
		super(owner, model);
	}

	@Override
	public void comienzo(Panel panel) {
		
        this.setTitle("Nueva metodologia");
		
		new Label(panel).setText("Nombre de la nueva metodologia");
		new Label(panel); //Espacio
		
		new TextBox(panel).bindValueToProperty("nombreMetodologia");
		new Label(panel); //Espacio
		
	}

	@Override
	public void ponerNombreEnBuilder() {
		
		this.getModelObject().getMiMetodologiaBuilder().setNombreMetodologia(this.getModelObject().getNombreMetodologia());
		
	}
	
}
