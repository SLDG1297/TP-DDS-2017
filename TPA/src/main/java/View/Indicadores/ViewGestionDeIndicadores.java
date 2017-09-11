package View.Indicadores;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class ViewGestionDeIndicadores extends Window<VMGestionDeIndicadores> {
	
	private static final long serialVersionUID = 2L;

	public ViewGestionDeIndicadores(WindowOwner panelPrincipal, VMGestionDeIndicadores gestionador) {
		super(panelPrincipal, gestionador);
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		this.setTitle("Gestion de indicadores");

		new Button(panelPrincipal).setCaption("Consultar indicadores").onClick(() -> new ViewEvaluacionIndicadores(this,new VMEvaluacionIndicadores()).open());
		
		new Button(panelPrincipal).setCaption("Ingresar nuevos Indicadores").onClick(() -> new ViewNuevosIndicadores(this,new VMNuevosIndicadores()).open());

		new Button(panelPrincipal).setCaption("Eliminar indicadores").onClick(() -> new ViewEliminarIndicador(this,new VMEliminarIndicador()).open());


	}
	
}