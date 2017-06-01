package View;

import java.io.IOException;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

import Archivo.Instanciador_Bolsa_Empresas;
import Indicadores.IndicadoresRepository;
import Modelo.BolsaDeEmpresas;

public class ViewMain extends MainWindow<VM_Main> {

	private static final long serialVersionUID = 1L;
	
	VMCargarCuentas miBolsa;
	
	VMIndicadores misIndicadores;
	
	public ViewMain(BolsaDeEmpresas bolsaEmpresas, IndicadoresRepository indicadores) {
		super(new VM_Main());
		//Se carga el viewModel para la pr�xima ventana con la bolsa de empresas ya cargadas
		miBolsa = new VMCargarCuentas(bolsaEmpresas);
		misIndicadores = new VMIndicadores(indicadores);
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		this.setTitle("Sistema de inversiones v1.0");

		new Button(panelPrincipal).setCaption("Ingresar una nueva empresa");

		new Button(panelPrincipal).setCaption("Gestionar cuentas de las empresas").onClick(() -> new ViewCargarCuentas(this, miBolsa).open());

		new Button(panelPrincipal).setCaption("Comparar gr�ficamente empresas");
		
<<<<<<< HEAD
		new Button(panelPrincipal).setCaption("Gestionar indicadores").onClick(() -> new ViewIndicadores(this, misIndicadores).open());
=======
		new Button(panelPrincipal).setCaption("Gestionar Indicadores").onClick(() -> new ViewGestionDeIndicadores(this, new VMGestionDeIndicadores()).open());
>>>>>>> 8b82eff9c4e4914f589cada8ee2b76e9a19cef7e

	}

	public static void main(String[] args) throws IOException {
		Instanciador_Bolsa_Empresas instancia = new Instanciador_Bolsa_Empresas();
		// Instancio una bolsa de Empresas
		BolsaDeEmpresas bolsaEmpresas =  instancia.instanciar();
		
		// Se la paso al constructor de la view
		new ViewMain(bolsaEmpresas).startApplication();
		
	}

}
