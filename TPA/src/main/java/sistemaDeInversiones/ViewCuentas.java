package sistemaDeInversiones;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class ViewCuentas extends Window<BolsaComercial> {
	// No nos cierra del todo qué es WindowOwner. Así que se pone así para que no rompa Eclipse.
	public ViewCuentas(WindowOwner panelPrincipal, BolsaComercial unaBolsa) {
		super(panelPrincipal, unaBolsa);
	}

	@Override
	public void createContents(Panel panelGestionar) {
		this.setTitle("Consultar estado de las cuentas");

		new Label(panelGestionar).setText("Consultar cuentas de:");

		Selector<Empresa> selector = new Selector<Empresa>(panelGestionar);
		selector.bindValueToProperty("nombreEmpresa");
		selector.bindItemsToProperty("nombresEmpresas");
		
		Button cargarCuentas = new Button(panelGestionar);
		cargarCuentas.setCaption("Cargar cuentas");
		cargarCuentas.onClick(() -> this.getModelObject().buscarEmpresa(this.getModelObject().getNombreEmpresa()).cargarCuentas());
		
		// Acá habría que mostrar una tabla con las cuentas de las empresas.
	}
}
