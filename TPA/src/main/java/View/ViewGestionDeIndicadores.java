package View;

import java.io.IOException;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import Archivo.Instanciador_Bolsa_Empresas;
import Modelo.BolsaDeEmpresas;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Empresa;

//Aca llega la bolsa de empresas, pero no se hasta donde la tengo que mandar. La dejo de mandar aca y dsps se ve

public class ViewGestionDeIndicadores extends Window<VMGestionDeIndicadores> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	// No nos cierra del todo qué es WindowOwner. Así que se pone así para que no rompa Eclipse.
	public ViewGestionDeIndicadores(WindowOwner panelPrincipal, VMGestionDeIndicadores gestionador) {
		super(panelPrincipal, gestionador);
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		this.setTitle("Gestion de indicadores");

		new Button(panelPrincipal).setCaption("Consultar indicadores");
		//Ya no estoy mandando la bolsa ni el VM anterior
		new Button(panelPrincipal).setCaption("Ingresar nuevos Indicadores").onClick(() -> new ViewNuevosIndicadores(this,new VMNuevosIndicadores()).open());

		

	}
	
}