package View.Metodologias;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Metodologias.Comparadores.ComparadorMultiple;
import Modelo.Metodologias.Comparadores.ComparadorUnario;

public class ViewEvaluacionGlobal extends Window<VMEvaluacionGlobal>  {
		
		public ViewEvaluacionGlobal(WindowOwner panelPrincipal, VMEvaluacionGlobal vmEvaluacionGlobal) {
			super(panelPrincipal, vmEvaluacionGlobal);
		}

		@Override
		public void createContents(Panel panelPrincipal) {
			
			this.setTitle("Evaluacion global");
			
			new Label(panelPrincipal).setText("Elija metodologìa a utilizar");
			new Label(panelPrincipal);
			
			Selector<String> selector = new Selector<String>(panelPrincipal);
			selector.allowNull(false);
			selector.bindItemsToProperty("listaDeMetodologias");
			selector.bindValueToProperty("nombreMetodologiaElegida");
			
			new Label(panelPrincipal);
			new Button(panelPrincipal).setCaption("Seleccionar").onClick(() -> this.getModelObject().buscarMetodologia());
			
			new Label(panelPrincipal);
			new Button(panelPrincipal).setCaption("Evaluar").onClick(() -> {
				
				ComparadorMultiple comparador = new ComparadorMultiple(this.getModelObject().getMetodologiaElegida());
				new ViewResultadoGlobal(this,new VMResultadoGlobal(comparador.compararTodosconTodo())).open();

			});
		}}