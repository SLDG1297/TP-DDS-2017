package View.Metodologias.Comparacion;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;


public abstract class ViewEvaluacion extends Window<VMEvaluacion>{
	
	public ViewEvaluacion(WindowOwner panelPrincipal, VMEvaluacion VMEvaluacion) {
		super(panelPrincipal, VMEvaluacion);
	}
	
	public void mostrarMetodologias(Panel panelActual){
		
		new Label(panelActual).setText("Elija metodologia");
		new Label(panelActual);
		
		Selector<String> selectorMetodologia = new Selector<String>(panelActual);
		selectorMetodologia.allowNull(false);
		selectorMetodologia.bindItemsToProperty("listaDeMetodologias");
		selectorMetodologia.bindValueToProperty("nombreMetodologiaElegida");
		
		new Label(panelActual);
		new Button(panelActual).setCaption("Seleccionar").onClick(() -> this.getModelObject().buscarMetodologia());
		
	}
	
	public void mostrarEmpresas(Panel panelActual) {
		
		Selector<String> selectorEmpresa = new Selector<String>(panelActual);
		selectorEmpresa.allowNull(false);
		selectorEmpresa.bindItemsToProperty("listaDeEmpresas");
		selectorEmpresa.bindValueToProperty("nombreEmpresaElegida");
		
		new Label(panelActual);
		new Button(panelActual).setCaption("Seleccionar").onClick(() -> this.getModelObject().buscarEmpresa());
	}
	
	public void mostrarEmpresasSinEmpresaElegida(Panel panelActual) {
		
		
		Selector<String> selector2 = new Selector<String>(panelActual);
		selector2.allowNull(false);
		selector2.bindItemsToProperty("listaDeEmpresasSinEmpresaElegida");
		selector2.bindValueToProperty("nombreEmpresaB");
		
		new Label(panelActual);
		new Button(panelActual).setCaption("Seleccionar").onClick(() -> this.getModelObject().buscarEmpresaB());
	}

}
