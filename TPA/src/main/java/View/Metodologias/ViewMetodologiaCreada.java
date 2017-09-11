package View.Metodologias;

import java.awt.Color;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;


public class ViewMetodologiaCreada extends Window<VMMetodologiaCreada> {

	public ViewMetodologiaCreada(WindowOwner owner, VMMetodologiaCreada model) {
		super(owner, model);
	}

	@Override
	public void createContents(Panel panelMensaje) {
        this.setTitle("Confirmacion");
		
		new Label(panelMensaje).setText("Condiciones de la metodologia:");
		
		new Label(panelMensaje).setBackground(Color.WHITE).bindValueToProperty("miCadena");
		
		new Label(panelMensaje); //Espacio
		new Label(panelMensaje).setText("Metodologia creada correctamente");
		new Label(panelMensaje); //Espacio
		
	}
	
}
