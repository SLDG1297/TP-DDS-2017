package sistemaDeInversiones;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class ViewGestionar extends Window<BolsaComercial> {
	public ViewGestionar(WindowOwner panelPrincipal, BolsaComercial unaBolsa) {
		super(panelPrincipal, unaBolsa);
	}

	@Override
	public void createContents(Panel panelGestionar) {
		this.setTitle("Gestionar estado de las empresas");

		new Label(panelGestionar).setText("Listado de empresas");
		
		//Crear lista de empresa
		Selector<Empresa> selector = new Selector<Empresa>(panelGestionar);
		selector.bindValueToProperty("nombre");
		selector.bindItemsToProperty("empresas");

		new Button(panelGestionar)
			.setCaption("Consultar cuentas")
			.onClick(() -> this.getModelObject().buscarEmpresa("nombre").cargarCuentas());
	}
}
