package View.Metodologias.Comparacion;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Metodologias.Comparadores.ComparadorMultiple;


public class ViewEvaluacionGlobal extends ViewEvaluacion  {
		
		public ViewEvaluacionGlobal(WindowOwner panelPrincipal, VMEvaluacion vmEvaluacion) {
			super(panelPrincipal, vmEvaluacion);
		}

		@Override
		public void createContents(Panel panelPrincipal) {
			
			this.setTitle("Evaluacion global");
			mostrarMetodologias(panelPrincipal);
			
			new Label(panelPrincipal);
			new Button(panelPrincipal).setCaption("Evaluar").onClick(() -> {
				
				ComparadorMultiple comparador = new ComparadorMultiple(this.getModelObject().getMetodologiaElegida());
				new ViewResultadoGlobal(this,new VMResultadoGlobal(comparador.compararTodosconTodo())).open();

			});
			
		}
		
	}