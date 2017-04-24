package sistemaDeInversiones;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

public class ViewMain extends MainWindow<Empresa> {

	public ViewMain() {
		super(new Empresa());
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		this.setTitle("Sistema de inversiones v1.0");

		new Button(panelPrincipal).setCaption("Ingresar una nueva empresa");

		new Button(panelPrincipal).setCaption("Gestionar estado de las empresas")
			.onClick(() -> new ViewGestionar(this, new Empresa()).open());

		new Button(panelPrincipal).setCaption("Comparar gráficamente empresas");

	}

	public static void main(String[] args) {
		new ViewMain().startApplication();
	}

}
