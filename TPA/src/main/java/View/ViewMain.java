package View;

import java.io.IOException;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import Archivo.Instanciador_Bolsa_Empresas;
import Modelo.AlmacenIndicadores;


public class ViewMain extends MainWindow<VM_Main> {

	private static final long serialVersionUID = 1L;
	
		
	public ViewMain() {
		super(new VM_Main());
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		this.setTitle("Sistema de inversiones v1.0");

		new Button(panelPrincipal).setCaption("Ingresar una nueva empresa");

		new Button(panelPrincipal).setCaption("Gestionar cuentas de las empresas").onClick(() -> new ViewCargarCuentas(this, new VMCargarCuentas()).open());

		new Button(panelPrincipal).setCaption("Comparar gráficamente empresas");
		
		new Button(panelPrincipal).setCaption("Gestionar Indicadores").onClick(() -> new ViewGestionDeIndicadores(this, new VMGestionDeIndicadores()).open());
	}

	public static void main(String[] args) throws IOException {
		//Instancio una bolsa de Empresas y creo su archivo de repositorio.
		new Instanciador_Bolsa_Empresas().instanciar();
		AlmacenIndicadores.obtenerRepositorioIndicadores();
		new ViewMain().startApplication(); 
		
	}

}