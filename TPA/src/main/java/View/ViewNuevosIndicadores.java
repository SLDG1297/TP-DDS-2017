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
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Empresa;
import Modelo.IndicadorBuilder;

/*
  VMCargarCuentas miBolsa;
	
	public ViewMain(BolsaDeEmpresas bolsaEmpresas) {
		super(new VM_Main());
		//Se carga el viewModel para la pr�xima ventana con la bolsa de empresas ya cargadas
		miBolsa = new VMCargarCuentas(bolsaEmpresas);
	}
 */
public class ViewNuevosIndicadores extends Window<VMNuevosIndicadores> {
	
	IndicadorBuilder miIndicadorBuilder;
	

	// No nos cierra del todo qu� es WindowOwner. As� que se pone as� para que no rompa Eclipse.
	public ViewNuevosIndicadores(WindowOwner panelPrincipal, VMNuevosIndicadores nuevosIndicadores) {
		super(panelPrincipal, nuevosIndicadores);
		
		miIndicadorBuilder = new IndicadorBuilder();
	}
	
	@Override
	public void createContents(Panel panelNuevos) {
		
		this.setTitle("Nuevo indicador");
		
		new Label(panelNuevos).setText("Nombre del nuevo indicador");
		new Label(panelNuevos); //Espacio
		
		new TextBox(panelNuevos).bindValueToProperty("nombreDelIndicador");
		new Label(panelNuevos); //Espacio
		
		new Label(panelNuevos).setText("Elija el tipo del primer operando");
		
		Button indicador = new Button(panelNuevos);
		Button numero = new Button(panelNuevos);
		Button cuenta = new Button(panelNuevos);
		
		//el siguiente metodo de indicador le debe dar al builder el nombre del indicador que estamos creando. Decidir donde creo
		//ese builder para empezar a pasarlo.
		
		indicador.setCaption("Indicador").onClick(() -> miIndicadorBuilder.setNombreIndicador(this.getModelObject().getNombreDelIndicador()));
		indicador.onClick(() -> new ViewAgregarIndicador(this, new VMAgregarIndicador(miIndicadorBuilder)).open());
		
		numero.setCaption("Numero").onClick(() -> miIndicadorBuilder.setNombreIndicador(this.getModelObject().getNombreDelIndicador()));
		numero.onClick(() -> new ViewAgregarNumero(this, new VMAgregarNumero()).open());
		
		//cuenta.setCaption("Cuenta").onClick(() -> miIndicadorBuilder.setNombreIndicador(this.getModelObject().getNombreDelIndicador()));
		//cuenta.onClick(() -> new ViewAgregarCuenta(this, new VMAgregarCuenta()).open());
		
	}
	
}
