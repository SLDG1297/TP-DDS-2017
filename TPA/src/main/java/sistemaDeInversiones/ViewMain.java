package sistemaDeInversiones;

import java.io.IOException;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

public class ViewMain extends MainWindow<VMPrincipal> {
	// Esto no debería tener un ViewModel, al menos por ahora. Es sólo una vista que lleva a otras vistas.
	// Se hardcodea así para Eclipse no rompa.
	
	VMBolsaComercial miBolsa;
	
	public ViewMain(BolsaDeEmpresas bolsaEmpresas) {
		super(new VMPrincipal());
		//Se carga el viewModel para la próxima ventana con la bolsa de empresas ya cargadas
		miBolsa = new VMBolsaComercial(bolsaEmpresas);
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		this.setTitle("Sistema de inversiones v1.0");

		new Button(panelPrincipal).setCaption("Ingresar una nueva empresa");

		new Button(panelPrincipal).setCaption("Gestionar cuentas de las empresas").onClick(() -> new ViewCargarCuentas(this,miBolsa).open());

		new Button(panelPrincipal).setCaption("Comparar gráficamente empresas");

	}

	public static void main(String[] args) throws IOException {
	
		// Instancio una bolsa de Empresas
		BolsaDeEmpresas bolsaEmpresas =  Instanciador_Bolsa_Empresas.instanciar();
		
		// Se la paso al constructor de la view
		new ViewMain(bolsaEmpresas).startApplication();
		
	}

}
