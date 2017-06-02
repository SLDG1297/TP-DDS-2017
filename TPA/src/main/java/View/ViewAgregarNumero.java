package View;

import java.awt.Color;
import java.io.IOException;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import Archivo.Instanciador_Bolsa_Empresas;
import Modelo.BolsaDeEmpresas;
import Modelo.CadenaActualDeMiIndicador;
import Modelo.Division;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
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
	
	public ViewAgregarNumero(WindowOwner panelPrincipal, VMAgregarNumero vmNumero) {
		super(panelPrincipal, vmNumero);
		
	
	}

	@Override
	public void createContents(Panel panelNumero) {
		
		this.setTitle("Nuevo operando numero");
		
		new Label(panelNumero).setText("Estado actual del indicador:");
		new Label(panelNumero).setBackground(Color.WHITE).bindValueToProperty("miCadena");
		new Label(panelNumero); // Espacio
		
		new Label(panelNumero).setText("Escriba el nuevo operando numero");
		new Label(panelNumero); //Espacio
		

		new NumericField(panelNumero).bindValueToProperty("numeroElegido");
		new Label(panelNumero); //Espacio
	
		Button suma = new Button(panelNumero).setCaption("Sumar");
		Button resta = new Button(panelNumero).setCaption("Resta");
		Button multiplicar = new Button(panelNumero).setCaption("Multiplicar");
		Button dividir = new Button(panelNumero).setCaption("Dividir");
		new Label(panelNumero); //Espacio
		
		Button crear = new Button(panelNumero).setCaption("Crear indicador");		
	
		suma.onClick(() -> {
			
			this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverNumero());
			CadenaActualDeMiIndicador.instanciar().agregar(this.getModelObject().getNumeroElegido());
			this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Suma(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			CadenaActualDeMiIndicador.instanciar().agregar("+");
			new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open();
			
		});
		
		crear.onClick(() -> {
			
			this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverNumero());
			CadenaActualDeMiIndicador.instanciar().eliminarCadenaActual();
			this.getModelObject().miIndicadorBuilder.crearIndicador();
			
		});
		
		resta.onClick(() -> {
			
			this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverNumero());
			CadenaActualDeMiIndicador.instanciar().agregar((this.getModelObject().getNumeroElegido()));
			this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Resta(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			CadenaActualDeMiIndicador.instanciar().agregar("-");
			new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open();
	
		});
				
		multiplicar.onClick(() -> {
			
			this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverNumero());
			CadenaActualDeMiIndicador.instanciar().agregar((this.getModelObject().getNumeroElegido()));
			this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Multiplicacion(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			CadenaActualDeMiIndicador.instanciar().agregar("*");
			new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open();
			
		});
		
		dividir.onClick(() -> {
			
			this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverNumero());
			CadenaActualDeMiIndicador.instanciar().agregar((this.getModelObject().getNumeroElegido()));
			this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Division(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			CadenaActualDeMiIndicador.instanciar().agregar("/");
			new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open();
			
		});
		
		new Label(panelNumero); //Espacio
		
		crear.setCaption("Crear Indicador");
		
	}
}