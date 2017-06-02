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
		
		Button suma = new Button(panelNumero).setCaption("Sumar");
		Button resta = new Button(panelNumero).setCaption("Resta");
		Button multiplicar = new Button(panelNumero).setCaption("Multiplicar");
		Button dividir = new Button(panelNumero).setCaption("Dividir");
		new Label(panelNumero); //Espacio
		
		Button crear = new Button(panelNumero).setCaption("Crear indicador");		
	
		
		suma.onClick(() -> {
			
			this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverCuenta());
			CadenaActualDeMiIndicador.instanciar().agregar(this.getModelObject().getCuentaElegida());
			this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Suma(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			CadenaActualDeMiIndicador.instanciar().agregar("+");
			new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open();
			
		});
		
		crear.onClick(() -> {
			
			this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverCuenta());
			
			/*try {
				AlmacenIndicadores.almacenarRepositorioIndicadores("repositorioIndicadores");
			} catch (IOException e) {
				
				e.printStackTrace();
			}*/
			this.getModelObject().miIndicadorBuilder.crearIndicador();
			CadenaActualDeMiIndicador.instanciar().agregar(this.getModelObject().getCuentaElegida());
			new ViewIndicadorCreado(this, new VMIndicadorCreado()).open();
			CadenaActualDeMiIndicador.instanciar().eliminarCadenaActual();
			
					
		});
		
		resta.onClick(() -> {
			
			this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverCuenta());
			CadenaActualDeMiIndicador.instanciar().agregar((this.getModelObject().getCuentaElegida()));
			this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Resta(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			CadenaActualDeMiIndicador.instanciar().agregar("-");
			new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open();
	
		});
				
		multiplicar.onClick(() -> {
			
			this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverCuenta());
			CadenaActualDeMiIndicador.instanciar().agregar((this.getModelObject().getCuentaElegida()));
			this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Multiplicacion(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			CadenaActualDeMiIndicador.instanciar().agregar("*");
			new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open();
			
		});
		
		dividir.onClick(() -> {
			
			this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.getModelObject().devolverCuenta());
			CadenaActualDeMiIndicador.instanciar().agregar((this.getModelObject().getCuentaElegida()));
			this.getModelObject().miIndicadorBuilder.setOperandoAnterior(new Division(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			CadenaActualDeMiIndicador.instanciar().agregar("/");
			new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open();
			
		});
		
	}
}