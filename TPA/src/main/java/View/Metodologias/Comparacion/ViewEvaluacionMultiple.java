package View.Metodologias.Comparacion;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Metodologias.Comparadores.ComparadorMultiple;


public class ViewEvaluacionMultiple extends ViewEvaluacion  {
		
		public ViewEvaluacionMultiple(WindowOwner panelPrincipal, VMEvaluacion vmEvaluacion) {
			super(panelPrincipal, vmEvaluacion);
		}

		@Override
		public void createContents(Panel panelPrincipal) {
			
			this.setTitle("Evaluacion Multiple");
			mostrarMetodologias(panelPrincipal);
			
			new Label(panelPrincipal);
			new Label(panelPrincipal).setText("Seleccione la empresa a comparar con las demas");
			new Label(panelPrincipal);
			
			mostrarEmpresas(panelPrincipal);
			
			new Label(panelPrincipal);
			new Button(panelPrincipal).setCaption("Evaluar").onClick(() -> {
				
				ComparadorMultiple comparador = new ComparadorMultiple(this.getModelObject().getEmpresaElegida(), this.getModelObject().getMetodologiaElegida());				
				new ViewResultadoMultiple(this,new VMResultadoMultiple(comparador.comparar())).open();
			});
			
		}

	}