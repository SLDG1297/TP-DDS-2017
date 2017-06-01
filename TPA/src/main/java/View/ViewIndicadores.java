package View;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Empresa;

public class ViewIndicadores extends Window<VMIndicadores> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	VMIndicadores misIndicadoresVM; // No sé si esta bien
		
	public ViewIndicadores(WindowOwner panelPrincipal, VMIndicadores indicadores) {
		super(panelPrincipal, indicadores);
		misIndicadoresVM = indicadores; // No sé si esta bien
	}
	
	@Override
	public void createContents(Panel panelGestionar) {
		this.setTitle("Gestionar indicadores");

		new Button(panelGestionar).setCaption("Ingresar un nuevo indicador");

		new Button(panelGestionar).setCaption("Indicadores disponibles");
		
	}
}
