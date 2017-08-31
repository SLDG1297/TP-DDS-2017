package View.Metodologias;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Metodologias.Metodologia;

public class ViewAgregarPromedioSumatoriaMediana extends Window<VMAgregarPromedioSumatoriaMediana> {

	public ViewAgregarPromedioSumatoriaMediana(WindowOwner owner, VMAgregarPromedioSumatoriaMediana model) {
		super(owner, model);
	}

	@Override
	public void createContents(Panel panel) {
		
		new Label(panel).setText("Elegir si quiere un promedio, sumatoria o mediana");
		new Label(panel); //Espacio
		
		RadioSelector<String> radio1 = new RadioSelector<String>(panel);
		radio1.bindValueToProperty("operacionElegida");
		radio1.bindItemsToProperty("operaciones");
		
		new Label(panel).setText("Elegir si quiere que la operacion sea mayor o menor a un valor");
		new Label(panel); //Espacio

		RadioSelector<String> radio2 = new RadioSelector<String>(panel);
		radio2.bindValueToProperty("comparadorElegido");
		radio2.bindItemsToProperty("comparadores");
		
		new Label(panel).setText("Ingresar valor a comparar");
		new Label(panel); //Espacio
		
		new NumericField(panel).bindValueToProperty("valorElegido");
		new Label(panel); //Espacio
		
		Button agregarCondicion = new Button(panel).setCaption("Agregar condicion");
		agregarCondicion.onClick(()-> {
		this.getModelObject().crearCondicion();
		new ViewMasCondiciones(this, new VMSeleccionCondicion(this.getModelObject().getMiMetodologiaBuilder())).open();
		});
		Button finalizarMetodologia = new Button(panel).setCaption("Finalizar metodologia");
		finalizarMetodologia.onClick(()->{
		this.getModelObject().crearCondicion();
		Metodologia miMetodologia = this.getModelObject().crearMetodologia();
	
		new ViewMetodologiaCreada(this, new VMMetodologiaCreada(miMetodologia)).open();
		});
		
	}
	
}

