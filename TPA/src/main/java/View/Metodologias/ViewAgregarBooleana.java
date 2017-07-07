package View.Metodologias;

import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Metodologias.MetodologiaBuilder;

public class ViewAgregarBooleana extends Window<VMAgregarBooleana> {

	public ViewAgregarBooleana(WindowOwner owner, VMAgregarBooleana model) {
		super(owner, model);
	}
	
	@Override
	public void createContents(Panel panel) {
		
		new Label(panel).setText("Mayor o menor a un valor en N periodos");
		new Label(panel); //Espacio
		
		RadioSelector<String> radio = new RadioSelector<String>(panel);
		radio.bindValueToProperty("operacionElegida");
		radio.bindItemsToProperty("operaciones");

		new NumericField(panel).bindValueToProperty("valorElegido");
		new Label(panel); //Espacio
		
		Button agregarCondicion = new Button(panel).setCaption("Agregar condicion");
		agregarCondicion.onClick(()-> new ViewMasCondiciones(this, new VMMasCondiciones(this.getModelObject().getMiMetodologiaBuilder())));
		Button finalizarMetodologia = new Button(panel).setCaption("Finalizar metodologia");
		
	}
	
}
