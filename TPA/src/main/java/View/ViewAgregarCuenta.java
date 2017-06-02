package View;


import java.awt.Color;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import Modelo.Division;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.CadenaActualDeMiIndicador;
import Modelo.Multiplicacion;
import Modelo.Resta;
import Modelo.Suma;

public class ViewAgregarCuenta extends Window<VMAgregarCuenta> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewAgregarCuenta(WindowOwner panelPrincipal, VMAgregarCuenta vmAgregarCuenta) {
		super(panelPrincipal, vmAgregarCuenta);
	}

	@Override
	public void createContents(Panel panelNumero) {
		
		this.setTitle("Nuevo operando cuenta");
		
		new Label(panelNumero).setText("Estado actual del indicador:");
		new Label(panelNumero).setBackground(Color.WHITE).bindValueToProperty("miCadena");
		new Label(panelNumero); // Espacio
		
		new Label(panelNumero).setText("Escriba el nuevo operando cuenta");
		new Label(panelNumero).setText("(La cuenta debe existir en el sistema)");
		
		new TextBox(panelNumero).bindValueToProperty("cuentaElegida");
		
		Button suma = new Button(panelNumero);
		Button resta = new Button(panelNumero);
		Button multiplicar = new Button(panelNumero);
		Button dividir = new Button(panelNumero);
		new Label(panelNumero); //Espacio
		
		Button crear = new Button(panelNumero);		
		
		//crear.setCaption("Crear indicador").onClick(() -> this.getModelObject().crearIndicador());
		//suma.setCaption("Sumar").onClick(() -> this.getModelObject().realizarSuma());
		//suma.onClick(() -> new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open());
		//resta.setCaption("Resta").onClick(() -> this.getModelObject().realizarResta());
		//multiplicar.setCaption("Multiplicar").onClick(() -> this.getModelObject().realizarMultiplicacion());
		//dividir.setCaption("Dividir").onClick(() -> this.getModelObject().realizarDivision());

		
		crear.onClick(() -> this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverCuenta()));
		crear.onClick(() -> this.getModelObject().miIndicadorBuilder.crearIndicador());
		
		suma.setCaption("Sumar").onClick(() -> this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverCuenta()));
		suma.onClick(() -> this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Suma(this.getModelObject().miIndicadorBuilder.getOperandoAnterior())));
		suma.onClick(() -> new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open());
		
		resta.setCaption("Resta").onClick(() -> this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverCuenta()));
		resta.onClick(() -> this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Resta(this.getModelObject().miIndicadorBuilder.getOperandoAnterior())));
		resta.onClick(() -> new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open());
		
		multiplicar.setCaption("Multiplicar").onClick(() -> this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverCuenta()));
		multiplicar.onClick(() -> this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Multiplicacion(this.getModelObject().miIndicadorBuilder.getOperandoAnterior())));
		multiplicar.onClick(() -> new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open());
		
		dividir.setCaption("Dividir").onClick(() -> this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverCuenta()));
		dividir.onClick(() -> this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Division(this.getModelObject().miIndicadorBuilder.getOperandoAnterior())));
		dividir.onClick(() -> new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open());
		
	}
}