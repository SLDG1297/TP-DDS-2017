package View.Metodologias;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class ViewResultadoDual extends Window<VMResultadoDual>  {
		
		public ViewResultadoDual(WindowOwner panelPrincipal, VMResultadoDual vmResultadoDual) {
			super(panelPrincipal, vmResultadoDual);
		}

		@Override
		public void createContents(Panel panelPrincipal) {
			
			this.setTitle("Resultado de la evaluacion");
			
			new Label(panelPrincipal).setText("Resultado:" + this.getModelObject().getResultado().getNombre());
			new Label(panelPrincipal);
			
				
		}
		
}