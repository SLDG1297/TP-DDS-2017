package View;

import java.awt.Color;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class ViewOperando extends Window<VMOperando> {

	private static final long serialVersionUID = 1L;

	public ViewOperando(WindowOwner panelPrincipal, VMOperando nuevoOperando) {
		super(panelPrincipal, nuevoOperando);
	}

	@Override
	public void createContents(Panel panelSuma) {

		this.setTitle("Nuevo operando");

		new Label(panelSuma).setText("Estado actual del indicador:");
		new Label(panelSuma).setBackground(Color.WHITE).bindValueToProperty("miCadena");
		new Label(panelSuma); // Espacio
		
		new Label(panelSuma).setText("Seleccione nuevo operando a sumar");
		new Label(panelSuma); // Espacio

		Button indicador = new Button(panelSuma).setCaption("Indicador");
		Button numero = new Button(panelSuma).setCaption("Numero");
		Button cuenta = new Button(panelSuma).setCaption("Cuenta");
		
		indicador.onClick(() -> new ViewAgregarIndicador(this, new VMAgregarIndicador(this.getModelObject().getMiIndicadorBuilder())).open());
		numero.onClick(() -> new ViewAgregarNumero(this, new VMAgregarNumero(this.getModelObject().getMiIndicadorBuilder())).open());
		cuenta.onClick(() -> new ViewAgregarCuenta(this, new VMAgregarCuenta(this.getModelObject().getMiIndicadorBuilder())).open());
		
	}
	
}