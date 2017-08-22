package View.Metodologias;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Metodologias.Metodologia;

public class ViewAgregarComportamiento extends Window<VMAgregarComportamiento> {

	public ViewAgregarComportamiento(WindowOwner owner, VMAgregarComportamiento model) {
		super(owner, model);
	}

	@Override
	public void createContents(Panel panel) {
		
		new Label(panel).setText("Comportamiento del indicador a lo largo de N periodos");
		new Label(panel); //Espacio
		
		RadioSelector<String> radio = new RadioSelector<String>(panel);
		radio.bindValueToProperty("comportamientoElegido");
		radio.bindItemsToProperty("comportamientos");
		
		new Label(panel).setText("Ingresar cantidad de periodos a considerar");
		new Label(panel); //Espacio
		
		new NumericField(panel).bindValueToProperty("periodoElegido");
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