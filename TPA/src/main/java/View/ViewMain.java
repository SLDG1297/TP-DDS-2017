package View;

import java.io.IOException;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import Archivo.Empresa.Instanciador_Bolsa_Empresas;
import View.Cuentas.VMCargarCuentas;
import View.Cuentas.ViewCargarCuentas;
import View.Indicadores.VMGestionDeIndicadores;
import View.Indicadores.ViewGestionDeIndicadores;
import View.Metodologias.VMGestionDeMetodologias;
import View.Metodologias.ViewGestionDeMetodologias;

public class ViewMain extends MainWindow<VM_Main> {
	
		
	public ViewMain() {
		super(new VM_Main());
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		this.setTitle("Sistema de inversiones");

		new Button(panelPrincipal).setCaption("Gestionar Cuentas").onClick(() -> new ViewCargarCuentas(this, new VMCargarCuentas()).open());
		
		new Button(panelPrincipal).setCaption("Gestionar Indicadores").onClick(() -> new ViewGestionDeIndicadores(this, new VMGestionDeIndicadores()).open());
		
		new Button(panelPrincipal).setCaption("Gestionar Metodologias").onClick(() -> new ViewGestionDeMetodologias(this, new VMGestionDeMetodologias()).open());

		
	}

	public static void main(String[] args) throws IOException {
		
		new Instanciador_Bolsa_Empresas().instanciar();
		
		new ViewMain().startApplication(); 
		
	}

}