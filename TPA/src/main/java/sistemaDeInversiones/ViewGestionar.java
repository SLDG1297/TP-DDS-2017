package sistemaDeInversiones;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class ViewGestionar extends Window<Empresa> {
	public ViewGestionar(WindowOwner panelPrincipal, Empresa unaEmpresa) {
		super(panelPrincipal, unaEmpresa);
	}

	@Override
	public void createContents(Panel panelGestionar) {
		this.setTitle("Gestionar estado de las empresas");

		new Label(panelGestionar).setText("Listado de empresas");

		Selector<Empresa> selector = new Selector<Empresa>(panelGestionar);
		selector.bindValueToProperty("nombre");
		selector.bindItemsToProperty("nombre");

		new Label(panelGestionar).setText("Acciones");

		new Button(panelGestionar)
			.setCaption("Ingresar cuentas")
			.onClick(() -> this.getModelObject().cargarCuentas());

		new Button(panelGestionar).setCaption("Consultar cuentas")
			.onClick(() -> new ViewConsultarCuentas(this, new Empresa()).open());
	}
}
