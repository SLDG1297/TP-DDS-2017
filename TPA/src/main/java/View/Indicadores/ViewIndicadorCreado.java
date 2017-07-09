package View.Indicadores;

import java.awt.Color;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class ViewIndicadorCreado extends Window<VMIndicadorCreado> {


	private static final long serialVersionUID = 1L;

	public ViewIndicadorCreado(WindowOwner panelMensaje, VMIndicadorCreado vmIndicadorCreado) {
		super(panelMensaje, vmIndicadorCreado);
	}

	@Override
	public void createContents(Panel panelMensaje) {
		
		this.setTitle("Confirmacion");
		
		new Label(panelMensaje).setText("Operacion del indicador:");
		new Label(panelMensaje).setBackground(Color.WHITE).bindValueToProperty("miCadena");
		
		new Label(panelMensaje); //Espacio
		new Label(panelMensaje).setText("Indicador creado correctamente");
		new Label(panelMensaje); //Espacio
		
	}


	
}
