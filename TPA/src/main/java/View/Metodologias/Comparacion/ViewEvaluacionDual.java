package View.Metodologias.Comparacion;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Metodologias.Comparadores.ComparadorDual;

public class ViewEvaluacionDual extends ViewEvaluacion  {
		
		public ViewEvaluacionDual(WindowOwner panelPrincipal, VMEvaluacion vmEvaluacion) {
			super(panelPrincipal, vmEvaluacion);
		}

		@Override
		public void createContents(Panel panelPrincipal) {
			this.setTitle("Evaluacion Dual");
			
			mostrarMetodologias(panelPrincipal);
			
			new Label(panelPrincipal);
			new Label(panelPrincipal).setText("Seleccione la primer empresa a comparar");
			new Label(panelPrincipal);
			
			mostrarEmpresas(panelPrincipal);
			
			new Label(panelPrincipal);
			new Label(panelPrincipal).setText("Seleccione la segunda empresa");
			new Label(panelPrincipal);
			
			mostrarEmpresasSinEmpresaElegida(panelPrincipal);
				
			new Label(panelPrincipal);
			
			new Button(panelPrincipal).setCaption("Evaluar").onClick(() -> {
				
				ComparadorDual comparador = new ComparadorDual(this.getModelObject().getEmpresaElegida(), this.getModelObject().getEmpresaB(), this.getModelObject().getMetodologiaElegida());				
				new ViewResultadoDual(this,new VMResultadoDual(comparador.comparar())).open();
			});
		}
		
		
		public void mostrarEmpresas(Panel panelActual) {
			
			Selector<String> selectorEmpresa = new Selector<String>(panelActual);
			selectorEmpresa.allowNull(false);
			selectorEmpresa.bindItemsToProperty("listaDeEmpresas");
			selectorEmpresa.bindValueToProperty("nombreEmpresaElegida");
			
			new Label(panelActual);
			new Button(panelActual).setCaption("Seleccionar").onClick(() -> {
				
				this.getModelObject().buscarEmpresa();
				this.getModelObject().generarListaSinPrimerEmpresaElegida();
	
			});
		}
}