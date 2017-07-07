package View.Metodologias;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Metodologias.Comparadores.ComparadorDual;

public class ViewEvaluacionDual extends Window<VMEvaluacionDual>  {
		
		public ViewEvaluacionDual(WindowOwner panelPrincipal, VMEvaluacionDual vmEvaluacionDual) {
			super(panelPrincipal, vmEvaluacionDual);
		}

		@Override
		public void createContents(Panel panelPrincipal) {
			this.setTitle("Evaluacion Dual");
			
			new Label(panelPrincipal).setText("Seleccione la metodologia a utilizar");
			new Label(panelPrincipal);
			
			Selector<String> selectorMetodologias = new Selector<String>(panelPrincipal);
			selectorMetodologias.allowNull(false);
			selectorMetodologias.bindItemsToProperty("listaDeMetodologias");
			selectorMetodologias.bindValueToProperty("nombreMetodologiaElegida");
			
			new Label(panelPrincipal);
			new Button(panelPrincipal).setCaption("Seleccionar").onClick(() -> this.getModelObject().buscarMetodologia());
			
			new Label(panelPrincipal);
			new Label(panelPrincipal).setText("Seleccione la primer empresa a comparar");
			new Label(panelPrincipal);
			
			Selector<String> selector = new Selector<String>(panelPrincipal);
			selector.allowNull(false);
			selector.bindItemsToProperty("listaDeEmpresas");
			selector.bindValueToProperty("nombreEmpresaA");
			
			new Label(panelPrincipal);
			new Button(panelPrincipal).setCaption("Seleccionar").onClick(() -> {
				
				this.getModelObject().buscarEmpresaA();
				this.getModelObject().generarListaSinA();

			});
		
			
			new Label(panelPrincipal);
			new Label(panelPrincipal).setText("Seleccione la segunda empresa");
			new Label(panelPrincipal);
			
			Selector<String> selector2 = new Selector<String>(panelPrincipal);
			selector2.allowNull(false);
			selector2.bindItemsToProperty("listaDeEmpresasSinEmpresaA");
			selector2.bindValueToProperty("nombreEmpresaB");
			
			new Label(panelPrincipal);
			new Button(panelPrincipal).setCaption("Seleccionar").onClick(() -> this.getModelObject().buscarEmpresaB());
			
			new Label(panelPrincipal);
			new Button(panelPrincipal).setCaption("Evaluar").onClick(() -> {
				
				ComparadorDual comparador = new ComparadorDual(this.getModelObject().getEmpresaA(), this.getModelObject().getEmpresaB(), this.getModelObject().getMetodologiaElegida());				
				new ViewResultadoDual(this,new VMResultadoDual(comparador.comparar())).open();
			});
		}
}