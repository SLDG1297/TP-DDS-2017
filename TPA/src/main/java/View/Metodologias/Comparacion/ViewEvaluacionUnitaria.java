package View.Metodologias.Comparacion;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Metodologias.Comparadores.ComparadorUnario;

public class ViewEvaluacionUnitaria extends ViewEvaluacion  {
		
		public ViewEvaluacionUnitaria(WindowOwner panelPrincipal, VMEvaluacion vmEvaluacion) {
			super(panelPrincipal, vmEvaluacion);
		}

		@Override
		public void createContents(Panel panelPrincipal) {
			
			this.setTitle("Evaluacion unitaria");
			new Label(panelPrincipal).setText("Elija empresa a evaluar");
			new Label(panelPrincipal);
			
			mostrarEmpresas(panelPrincipal);
			
			new Label(panelPrincipal);
			mostrarMetodologias(panelPrincipal);

			new Label(panelPrincipal);
			new Button(panelPrincipal).setCaption("Evaluar").onClick(() -> {
				
				ComparadorUnario comparador = new ComparadorUnario(this.getModelObject().getEmpresaElegida(), this.getModelObject().getMetodologiaElegida());
				new ViewResultadoUnario(this,new VMResultadoUnario(comparador.evaluar())).open();

			});
			
		}
}