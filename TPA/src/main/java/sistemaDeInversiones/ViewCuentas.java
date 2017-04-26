package sistemaDeInversiones;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class ViewCuentas extends Window<BolsaComercial> {
	public ViewCuentas(WindowOwner panelPrincipal, BolsaComercial unaBolsa) {
		super(panelPrincipal, unaBolsa);
	}

	@Override
	public void createContents(Panel panelGestionar) {
		this.setTitle("Consultar estado de las cuentas");

		new Label(panelGestionar).setText("Listado de empresas");

		Selector<Empresa> selector = new Selector<Empresa>(panelGestionar);
		selector.bindValueToProperty("nombresDeEmpresas");
		selector.bindItemsToProperty("empresas");

		new Button(panelGestionar)
			.setCaption("Consultar cuentas")
			.onClick(() -> this.getModelObject().buscarEmpresa("nombresDeEmpresas").cargarCuentas());
	}
}
