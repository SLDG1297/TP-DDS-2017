package View;

import java.io.IOException;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import Archivo.Instanciador_Bolsa_Empresas;
import Modelo.BolsaDeEmpresas;
import Modelo.Division;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Empresa;
import Modelo.IndicadorBuilder;
import Modelo.Multiplicacion;
import Modelo.Resta;
import Modelo.Suma;

public class ViewAgregarNumero extends Window<VMAgregarNumero> {
	
	IndicadorBuilder miIndicadorBuilder;

	public ViewAgregarNumero(WindowOwner panelPrincipal, VMAgregarNumero vmNumero) {
		super(panelPrincipal, vmNumero);
		miIndicadorBuilder = vmNumero.getMiIndicadorBuilder();
	
	}

	@Override
	public void createContents(Panel panelNumero) {
		new Label(panelNumero).setText("Elija accion para el operando indicador elegido");
		new Label(panelNumero); //Espacio
		
		Button suma = new Button(panelNumero);
		Button resta = new Button(panelNumero);
		Button multiplicar = new Button(panelNumero);
		Button dividir = new Button(panelNumero);
		Button crear = new Button(panelNumero);
		
		suma.setCaption("Sumar").onClick(() -> this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().tomarIndicador()));
		suma.onClick(() -> this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Suma(this.getModelObject().miIndicadorBuilder.getOperandoAnterior())));
		suma.onClick(() -> new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open());
		
		resta.setCaption("Resta").onClick(() -> this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().tomarIndicador()));
		resta.onClick(() -> this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Resta(this.getModelObject().miIndicadorBuilder.getOperandoAnterior())));
		resta.onClick(() -> new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open());
		
		multiplicar.setCaption("Multiplicar").onClick(() -> this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().tomarIndicador()));
		multiplicar.onClick(() -> this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Multiplicacion(this.getModelObject().miIndicadorBuilder.getOperandoAnterior())));
		multiplicar.onClick(() -> new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open());
		

		dividir.setCaption("Dividir").onClick(() -> this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().tomarIndicador()));
		dividir.onClick(() -> this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Division(this.getModelObject().miIndicadorBuilder.getOperandoAnterior())));
		dividir.onClick(() -> new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open());

		
		new Label(panelNumero); //Espacio
		
		crear.setCaption("Crear Indicador");
		
	}
}