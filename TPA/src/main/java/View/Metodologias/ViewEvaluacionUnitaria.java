package View.Metodologias;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Metodologias.Comparadores.ComparadorUnario;

public class ViewEvaluacionUnitaria extends Window<VMEvaluacionUnitaria>  {
		
		public ViewEvaluacionUnitaria(WindowOwner panelPrincipal, VMEvaluacionUnitaria vmEvaluacionUnitaria) {
			super(panelPrincipal, vmEvaluacionUnitaria);
		}

		@Override
		public void createContents(Panel panelPrincipal) {
			
			this.setTitle("Evaluacion unitaria");
			
			new Label(panelPrincipal).setText("Elija empresa a evaluar");
			new Label(panelPrincipal);
			
			Selector<String> selectorEmpresa = new Selector<String>(panelPrincipal);
			selectorEmpresa.allowNull(false);
			selectorEmpresa.bindItemsToProperty("listaDeEmpresas");
			selectorEmpresa.bindValueToProperty("nombreEmpresaElegida");
			
			new Label(panelPrincipal);
			new Button(panelPrincipal).setCaption("Seleccionar").onClick(() -> this.getModelObject().buscarEmpresa());
			
			new Label(panelPrincipal);
			new Label(panelPrincipal).setText("Elija metodologia");
			
			new Label(panelPrincipal);
			
			Selector<String> selectorMetodologia = new Selector<String>(panelPrincipal);
			selectorMetodologia.allowNull(false);
			selectorMetodologia.bindItemsToProperty("listaDeMetodologias");
			selectorMetodologia.bindValueToProperty("nombreMetodologiaElegida");
			
			new Label(panelPrincipal);
			new Button(panelPrincipal).setCaption("Seleccionar").onClick(() -> this.getModelObject().buscarMetodologia());
			
			new Label(panelPrincipal);
			new Button(panelPrincipal).setCaption("Evaluar").onClick(() -> {
				
				ComparadorUnario comparador = new ComparadorUnario(this.getModelObject().getEmpresaElegida(), this.getModelObject().getMetodologiaElegida());
				new ViewResultadoUnario(this,new VMResultadoUnario(comparador.evaluar())).open();

			});
			
		}
}