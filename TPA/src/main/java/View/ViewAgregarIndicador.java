package View;

import java.awt.Color;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.CadenaActualDeMiIndicador;
import Modelo.Division;
import Modelo.Expresion;
import Modelo.Multiplicacion;
import Modelo.Resta;
import Modelo.Suma;

public class ViewAgregarIndicador extends Window<VMAgregarIndicador> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewAgregarIndicador(WindowOwner panelPrincipal, VMAgregarIndicador VMindicador) {
		super(panelPrincipal, VMindicador);
	}

	@Override
	public void createContents(Panel panelAgregarIndicador) {
		
		this.setTitle("Nuevo operando indicador");
		
		new Label(panelAgregarIndicador).setText("Estado actual del indicador:");
		new Label(panelAgregarIndicador).setBackground(Color.WHITE).bindValueToProperty("miCadena");
		new Label(panelAgregarIndicador); // Espacio
		
		new Label(panelAgregarIndicador).setText("Elija indicador");
		new Label(panelAgregarIndicador); //Espacio
		
		Selector<Expresion> selector = new Selector<Expresion>(panelAgregarIndicador);
		selector.bindValueToProperty("nombreDeIndicadorElegido");
		selector.bindItemsToProperty("nombresDeIndicadoresExistentes");
		
		new Label(panelAgregarIndicador).setText("Elija accion para el operando indicador elegido");
		new Label(panelAgregarIndicador); //Espacio
		
		Button suma = new Button(panelAgregarIndicador).setCaption("Sumar");
		Button resta = new Button(panelAgregarIndicador).setCaption("Resta");
		Button multiplicar = new Button(panelAgregarIndicador).setCaption("Multiplicar");
		Button dividir = new Button(panelAgregarIndicador).setCaption("Dividir");
		new Label(panelAgregarIndicador); //Espacio
		
		Button crear = new Button(panelAgregarIndicador).setCaption("Crear indicador");
	
		
		suma.onClick(() -> {
			
			this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverIndicador());
			CadenaActualDeMiIndicador.instanciar().agregar(this.getModelObject().getNombreDeIndicadorElegido());
			this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Suma(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			CadenaActualDeMiIndicador.instanciar().agregar("+");
			new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open();
			
		});
		
		crear.onClick(() -> {
			
			this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverIndicador());
			this.getModelObject().miIndicadorBuilder.crearIndicador();
			CadenaActualDeMiIndicador.instanciar().agregar(this.getModelObject().getNombreDeIndicadorElegido());
			new ViewIndicadorCreado(this, new VMIndicadorCreado()).open();
			CadenaActualDeMiIndicador.instanciar().eliminarCadenaActual();
			
		});
		
		resta.onClick(() -> {
			
			this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverIndicador());
			CadenaActualDeMiIndicador.instanciar().agregar(this.getModelObject().getNombreDeIndicadorElegido());
			this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Resta(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			CadenaActualDeMiIndicador.instanciar().agregar("-");
			new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open();
	
		});
				
		multiplicar.onClick(() -> {
			
			this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverIndicador());
			CadenaActualDeMiIndicador.instanciar().agregar(this.getModelObject().getNombreDeIndicadorElegido());
			this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Multiplicacion(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			CadenaActualDeMiIndicador.instanciar().agregar("*");
			new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open();
			
		});
		
		dividir.onClick(() -> {
			
			this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverIndicador());
			CadenaActualDeMiIndicador.instanciar().agregar(this.getModelObject().getNombreDeIndicadorElegido());
			this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Division(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			CadenaActualDeMiIndicador.instanciar().agregar("/");
			new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open();
			
		});
	}
	

}
