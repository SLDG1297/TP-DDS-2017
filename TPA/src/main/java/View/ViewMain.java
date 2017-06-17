package View;

import java.io.IOException;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

import Archivo.Empresa.Instanciador_Bolsa_Empresas;
import Archivo.Indicadores.AlmacenadorDeIndicadores;
import View.Cuentas.VMCargarCuentas;
import View.Cuentas.ViewCargarCuentas;
import View.Indicadores.VMGestionDeIndicadores;
import View.Indicadores.ViewGestionDeIndicadores;


public class ViewMain extends MainWindow<VM_Main> {
	
		
	public ViewMain() {
		super(new VM_Main());
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		this.setTitle("Sistema de inversiones");

		new Button(panelPrincipal).setCaption("Gestionar Cuentas").onClick(() -> new ViewCargarCuentas(this, new VMCargarCuentas()).open());
		
		new Button(panelPrincipal).setCaption("Gestionar Indicadores").onClick(() -> new ViewGestionDeIndicadores(this, new VMGestionDeIndicadores()).open());

		
	}

	public static void main(String[] args) throws IOException {
		//Instancio una bolsa de Empresas y creo su archivo de repositorio.
		new Instanciador_Bolsa_Empresas().instanciar();
		AlmacenadorDeIndicadores.getInstancia().obtenerRepositorioIndicadores();
		new ViewMain().startApplication(); 
		
	}

}