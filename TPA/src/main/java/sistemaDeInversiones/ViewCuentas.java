package sistemaDeInversiones;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class ViewCuentas extends Window<VMBolsaComercial> {
	//VMBolsaComercial miBolsa;
	
	// No nos cierra del todo qué es WindowOwner. Así que se pone así para que no rompa Eclipse.
	public ViewCuentas(WindowOwner panelPrincipal, VMBolsaComercial miNuevaBolsa) {
		super(panelPrincipal, miNuevaBolsa);
		//miBolsa = miNuevaBolsa;
	}
	
	@Override
	public void createContents(Panel panelGestionar) {
		this.setTitle("Consultar estado de las cuentas");

		new Label(panelGestionar).setText("Consultar cuentas de:");

		Selector<Empresa> selector = new Selector<Empresa>(panelGestionar);
		selector.bindValueToProperty("nombreEmpresa");
		selector.bindItemsToProperty("listaDeNombresDeEmpresas");
		
		
		Button cargarCuentas = new Button(panelGestionar);
		cargarCuentas.setCaption("Cargar cuentas");	
		//cargarCuentas.onClick(() -> this.getModelObject().buscarEmpresa());
		cargarCuentas.onClick(() -> new ViewTablaCuentas(this, new VMTablaCuentas(this.getModelObject())).open());
		
		// Acá habría que mostrar una tabla con las cuentas de las empresas.
	}
}
