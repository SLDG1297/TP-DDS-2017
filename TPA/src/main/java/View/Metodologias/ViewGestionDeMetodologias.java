package View.Metodologias;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Metodologias.MetodologiaBuilder;
import View.Metodologias.Comparacion.VMEvaluacionMetodologias;
import View.Metodologias.Comparacion.ViewEvaluacionMetodologias;

public class ViewGestionDeMetodologias extends Window<VMGestionDeMetodologias> {

	public ViewGestionDeMetodologias(WindowOwner panelPrincipal, VMGestionDeMetodologias gestionador) {
		super(panelPrincipal, gestionador);
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		this.setTitle("Gestion de metodologias");

		new Button(panelPrincipal).setCaption("Consultar metodologias").onClick(() -> new ViewEvaluacionMetodologias(this,new VMEvaluacionMetodologias()).open());
		
		new Button(panelPrincipal).setCaption("Ingresar nuevas metodologias").onClick(() -> new ViewCreacion(this,new VMSeleccionCondicion(new MetodologiaBuilder())).open());

		new Button(panelPrincipal).setCaption("Eliminar metodologias").onClick(() -> new ViewEliminarMetodologias(this,new VMEliminarMetodologias()).open());
	}
	
}
