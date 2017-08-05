package View.Metodologias;

import java.awt.Color;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

public class ViewMasCondiciones extends ViewSeleccionCondicion  {
	
	public ViewMasCondiciones(WindowOwner owner, VMSeleccionCondicion model) {
		super(owner, model);
	}

	@Override
	public void comienzo(Panel panel) {
		
		new Label(panel).setText("Condiciones actuales de la metodologia:");
		new Label(panel).setBackground(Color.WHITE).bindValueToProperty("miCadena");
		new Label(panel); //Espacio
		
	}

	@Override
	public void ponerNombreEnBuilder() {
		
		//No tiene que hacer nada porque solo se pone el nombre en el builder en la 1era de las vistas
		
	}
	
}
