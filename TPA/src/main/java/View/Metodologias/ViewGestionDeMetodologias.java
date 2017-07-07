package View.Metodologias;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class ViewGestionDeMetodologias extends Window<VMGestionDeMetodologias> {

	public ViewGestionDeMetodologias(WindowOwner panelPrincipal, VMGestionDeMetodologias gestionador) {
		super(panelPrincipal, gestionador);
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		this.setTitle("Gestion de metodologias");

		new Button(panelPrincipal).setCaption("Consultar metodologias").onClick(() -> new ViewEvaluacionMetodologias(this,new VMEvaluacionMetodologias()).open());
		
		new Button(panelPrincipal).setCaption("Ingresar nuevas metodologas").onClick(() -> new ViewCreacion(this,new VMCreacion()).open());

		new Button(panelPrincipal).setCaption("Eliminar metodologias (proximamente)").onClick(() -> new ViewEliminarMetodologias(this,new VMEliminarMetodologias()).open());
	}
	
}
