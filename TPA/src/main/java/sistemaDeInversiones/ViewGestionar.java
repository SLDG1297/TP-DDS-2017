package sistemaDeInversiones;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

public class ViewGestionar extends SimpleWindow<Empresa> {

	public ViewGestionar(WindowOwner panelPrincipal, Empresa unaEmpresa) {
		super(panelPrincipal, unaEmpresa);
	}

	@Override
	public void createContents(Panel mainPanel) {
		super.createContents(mainPanel);
	}
	
	@Override
	protected void addActions(Panel panelAcciones) {
		
	}

	@Override
	protected void createFormPanel(Panel panelGestionar) {
		this.setTitle("Gestionar estado de las empresas");

		new Label(panelGestionar).setText("Listado de empresas:\n");

		new Selector<Empresa>(panelGestionar);
		
		new Label(panelGestionar).setText("Acciones");
		
		new Button(panelGestionar);
	}
}
