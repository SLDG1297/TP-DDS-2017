package View.Metodologias;

import java.io.IOException;

import org.uqbar.arena.bindings.ObservableProperty;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.RadioSelector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Archivo.Metodologias.AlmacenadorDeMetodologias;
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

		new Label(panel).setText("Ingresar valor a comparar");
		new Label(panel); //Espacio
		
		new NumericField(panel).bindValueToProperty("valorElegido");
		new Label(panel); //Espacio
		
		new Label(panel).setText("Ingresar cantidad de periodos a considerar");
		new Label(panel); //Espacio
		
		new NumericField(panel).bindValueToProperty("periodoElegido");
		new Label(panel); //Espacio
		
		Button agregarCondicion = new Button(panel).setCaption("Agregar condicion");
		agregarCondicion.onClick(()-> {
		this.getModelObject().crearCondicion();
		new ViewMasCondiciones(this, new VMMasCondiciones(this.getModelObject().getMiMetodologiaBuilder())).open();
		});
		Button finalizarMetodologia = new Button(panel).setCaption("Finalizar metodologia");
		finalizarMetodologia.onClick(()->{
		this.getModelObject().crearCondicion();
		this.getModelObject().crearMetodologia();
			/*try {
				AlmacenadorDeMetodologias.getInstancia().almacenarRepositorioMetodologias();
			} catch (IOException e) {
				e.printStackTrace();
			}*/
		new ViewMetodologiaCreada(this, new VMMetodologiaCreada()).open();
		});
		
	}
	
}
