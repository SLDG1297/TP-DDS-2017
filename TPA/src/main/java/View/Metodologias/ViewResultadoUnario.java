package View.Metodologias;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;


public class ViewResultadoUnario extends Window<VMResultadoUnario> {

	public ViewResultadoUnario(WindowOwner panelPrincipal, VMResultadoUnario vmResultadoUnario) {
		super(panelPrincipal, vmResultadoUnario);
	}

	@Override
	public void createContents(Panel panelPrincipal) {
	
		this.setTitle("Resultado de la evaluacion");
		
		new Label(panelPrincipal).setText(this.getModelObject().darResultado());
		
		
	}

}