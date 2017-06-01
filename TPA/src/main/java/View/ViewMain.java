package View;

import java.io.IOException;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

import Archivo.Instanciador_Bolsa_Empresas;
import Modelo.BolsaDeEmpresas;

public class ViewMain extends MainWindow<VM_Main> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	VMCargarCuentas miBolsa;
	
	public ViewMain(BolsaDeEmpresas bolsaEmpresas) {
		super(new VM_Main());
		//Se carga el viewModel para la próxima ventana con la bolsa de empresas ya cargadas
		miBolsa = new VMCargarCuentas(bolsaEmpresas);
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		this.setTitle("Sistema de inversiones v1.0");

		new Button(panelPrincipal).setCaption("Ingresar una nueva empresa");

		new Button(panelPrincipal).setCaption("Gestionar cuentas de las empresas").onClick(() -> new ViewCargarCuentas(this,miBolsa).open());

		new Button(panelPrincipal).setCaption("Comparar gráficamente empresas");
		
		new Button(panelPrincipal).setCaption("Gestionar Indicadores").onClick(() -> new ViewGestionDeIndicadores(this, new VMGestionDeIndicadores()).open());

	}

	public static void main(String[] args) throws IOException {
		Instanciador_Bolsa_Empresas instancia = new Instanciador_Bolsa_Empresas();
		// Instancio una bolsa de Empresas
		BolsaDeEmpresas bolsaEmpresas =  instancia.instanciar();
		
		// Se la paso al constructor de la view
		new ViewMain(bolsaEmpresas).startApplication();
		
	}

}
