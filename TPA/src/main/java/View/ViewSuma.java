package View;

import java.io.IOException;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import Archivo.Instanciador_Bolsa_Empresas;
import Modelo.BolsaDeEmpresas;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Empresa;

public class ViewSuma extends Window<VMIngresarOperando> {

	
	
	public ViewSuma(WindowOwner panelPrincipal, VMIngresarOperando nuevoOperando) {
		super(panelPrincipal, nuevoOperando);
	}
	
	
	@Override
	public void createContents(Panel panelSuma) {
		
		this.setTitle("Suma");
		
		new Label(panelSuma).setText("Seleccione nuevo operando a sumar");
		new Label(panelSuma); //Espacio
		
		Button indicador = new Button(panelSuma).setCaption("Indicador");
		Button numero = new Button(panelSuma).setCaption("Numero");
		Button cuenta = new Button(panelSuma).setCaption("Cuenta");
	
	}

}