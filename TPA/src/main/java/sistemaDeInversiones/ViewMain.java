package sistemaDeInversiones;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

public class ViewMain extends MainWindow<Empresa> {
	// Esto no debería tener un ViewModel, al menos por ahora. Es sólo una vista que lleva a otras vistas.
	// Se hardcodea así para Eclipse no rompa.
	public ViewMain() {
		super(new Empresa("Bolsa de empresas"));
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		this.setTitle("Sistema de inversiones v1.0");

		new Button(panelPrincipal).setCaption("Ingresar una nueva empresa");

		new Button(panelPrincipal).setCaption("Gestionar cuentas de las empresas").onClick(() -> new ViewCuentas(this, new BolsaComercial()).open());

		new Button(panelPrincipal).setCaption("Comparar gráficamente empresas");

	}

	public static void main(String[] args) {
		new ViewMain().startApplication();
	}

}
