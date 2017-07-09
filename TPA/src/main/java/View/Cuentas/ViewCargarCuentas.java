package View.Cuentas;

import org.uqbar.arena.widgets.Button;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Empresa.Empresa;

public class ViewCargarCuentas extends Window<VMCargarCuentas> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	// No nos cierra del todo qué es WindowOwner. Así que se pone así para que no rompa Eclipse.
	public ViewCargarCuentas(WindowOwner panelPrincipal, VMCargarCuentas VM) {
		super(panelPrincipal, VM);
	}
	
	@Override
	public void createContents(Panel panelGestionar) {
		this.setTitle("Consultar estado de las cuentas");

		new Label(panelGestionar).setText("Consultar cuentas de:");
		new Label(panelGestionar); //Para dejar espacio
        
		//Aca se elige la empresa de la que se desea ver sus cuentas.
		Selector<Empresa> selectorEmpresa = new Selector<Empresa>(panelGestionar);
		selectorEmpresa.bindValueToProperty("nombreEmpresa");
		selectorEmpresa.bindItemsToProperty("listaDeNombresDeEmpresas");
		//selectorEmpresa.onSelection(() -> this.getModelObject().buscarEmpresaYSusPeriodos());

		
		//Botón para que se cargue la empresa seleccionada en el viewModel para poder ver
		//los periodos de la misma en el selector.
		Button elegirEmpresa = new Button(panelGestionar);
		elegirEmpresa.setCaption("Elegir empresa");
		elegirEmpresa.onClick(() -> this.getModelObject().buscarEmpresaYSusPeriodos());
		
		
		new Label(panelGestionar); //Para dejar espacio
		new Label(panelGestionar).setText("Elegir periodo");
		new Label(panelGestionar); //Para dejar espacio
		
		
		//Selector para elegir un determinado periodo para una empresa
		Selector<Integer> selectorPeriodo = new Selector<Integer>(panelGestionar);
		selectorPeriodo.bindValueToProperty("periodoElegido");
		selectorPeriodo.bindItemsToProperty("listaDePeriodosDeEmpresa");
	
		
		Button cargarCuentas = new Button(panelGestionar);
		cargarCuentas.setCaption("Cargar cuentas");	
		//Se le pasa a la otra vista la empresa seleccionada en el selector
		cargarCuentas.onClick(() -> new ViewTablaCuentas(this, new VMTablaCuentas(this.getModelObject())).open());
	}
}
