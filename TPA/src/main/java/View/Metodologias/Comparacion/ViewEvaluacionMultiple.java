package View.Metodologias.Comparacion;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Metodologias.Comparadores.ComparadorMultiple;


public class ViewEvaluacionMultiple extends Window<VMEvaluacionMultiple>  {
		
		public ViewEvaluacionMultiple(WindowOwner panelPrincipal, VMEvaluacionMultiple vmEvaluacionMultiple) {
			super(panelPrincipal, vmEvaluacionMultiple);
		}

		@Override
		public void createContents(Panel panelPrincipal) {
			
			this.setTitle("Evaluacion Multiple");
			
			new Label(panelPrincipal).setText("Seleccione metodologia");
			new Label(panelPrincipal);
			
			Selector<String> selectorMetodologias = new Selector<String>(panelPrincipal);
			selectorMetodologias.allowNull(false);
			selectorMetodologias.bindItemsToProperty("listaDeMetodologias");
			selectorMetodologias.bindValueToProperty("nombreMetodologiaElegida");
			
			//Podria hacer algo para no repetir este codigo en la vm (buscar metodologia)?
			new Label(panelPrincipal);
			new Button(panelPrincipal).setCaption("Seleccionar").onClick(() -> this.getModelObject().buscarMetodologia());
			
			new Label(panelPrincipal);
			new Label(panelPrincipal).setText("Seleccione la empresa a comparar con las demas");
			new Label(panelPrincipal);
			
			Selector<String> selector = new Selector<String>(panelPrincipal);
			selector.allowNull(false);
			selector.bindItemsToProperty("listaDeEmpresas");
			selector.bindValueToProperty("nombreEmpresa");
			
			new Label(panelPrincipal);
			new Button(panelPrincipal).setCaption("Seleccionar").onClick(() -> this.getModelObject().buscarEmpresa());
			
			new Label(panelPrincipal);
			new Button(panelPrincipal).setCaption("Evaluar").onClick(() -> {
				
				ComparadorMultiple comparador = new ComparadorMultiple(this.getModelObject().getEmpresa(), this.getModelObject().getMetodologiaElegida());				
				new ViewResultadoMultiple(this,new VMResultadoMultiple(comparador.comparar())).open();
			});
			
		}

	}