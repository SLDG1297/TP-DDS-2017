package sistemaDeInversiones;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class ViewCargarCuentas extends Window<VMBolsaComercial> {
	
	// No nos cierra del todo qué es WindowOwner. Así que se pone así para que no rompa Eclipse.
	public ViewCargarCuentas(WindowOwner panelPrincipal, VMBolsaComercial miNuevaBolsa) {
		super(panelPrincipal, miNuevaBolsa);
	}
	
	@Override
	public void createContents(Panel panelGestionar) {
		this.setTitle("Consultar estado de las cuentas");

		new Label(panelGestionar).setText("Consultar cuentas de:");
		new Label(panelGestionar);
        
		//Aca se elige la empresa de la que se desea ver sus cuentas.
		Selector<Empresa> selectorEmpresa = new Selector<Empresa>(panelGestionar);
		selectorEmpresa.bindValueToProperty("nombreEmpresa");
		selectorEmpresa.bindItemsToProperty("listaDeNombresDeEmpresas");
		selectorEmpresa.onSelection(() -> this.getModelObject().buscarEmpresa());
		
		/*
		//Botón para que se cargue la empresa seleccionada en el viewModel para poder ver
		//los periodos de la misma en el selector.
		Button elegirEmpresa = new Button(panelGestionar);
		elegirEmpresa.setCaption("Elegir empresa");
		elegirEmpresa.onClick(() -> this.getModelObject().buscarEmpresa());
		*/
		
		new Label(panelGestionar).setText("Elegir periodo");
		
		//Selector para elegir un determinado periodo para una empresa
		Selector<Periodo> selectorPeriodo = new Selector<Periodo>(panelGestionar);
		selectorPeriodo.bindValueToProperty("periodoElegido");
		selectorPeriodo.bindValueToProperty("listaDePeriodosDeEmpresa");
		
		
	
		
		Button cargarCuentas = new Button(panelGestionar);
		cargarCuentas.setCaption("Cargar cuentas");	
		//cargarCuentas.onClick(() -> this.getModelObject().buscarEmpresa());
		//Se le pasa a la otra vista la empresa seleccionada en el selector
		cargarCuentas.onClick(() -> new ViewTablaCuentas(this, new VMTablaCuentas(this.getModelObject())).open());
	}
}
