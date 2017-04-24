package sistemaDeInversiones;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class ViewConsultarCuentas extends Window<Empresa> {

	public ViewConsultarCuentas(WindowOwner panelGestionar, Empresa unaEmpresa) {
		super(panelGestionar, unaEmpresa);
	}

	@Override
	public void createContents(Panel panelConsultar) {

		this.setTitle("Consultar cuentas de una empresa");
		
		new Label(panelConsultar).setText("Estado de las cuentas de "/*.concat(this.getModelObject().getNombre())*/);

		//Muestra una tabla con las cuentas de las empresas.
		
	}
}
