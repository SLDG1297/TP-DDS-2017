package View;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Empresa;
import Modelo.Indicador;

public class ViewEvaluacionIndicadores extends Window<VMEvaluacionIndicadores>  {

	private static final long serialVersionUID = 1L;

	public ViewEvaluacionIndicadores(WindowOwner owner, VMEvaluacionIndicadores model) {
		super(owner, model);
	}
	
	@Override
	public void createContents(Panel panelEvaluar) {
	
    this.setTitle("Evaluar empresas con indicadores en determinado periodo");
    
    new Label(panelEvaluar).setText("Buscar empresa:");
	new Label(panelEvaluar); //Para dejar espacio
    
	//Aca se elige la empresa que se desea evaluar
	Selector<Empresa> selectorEmpresa = new Selector<Empresa>(panelEvaluar);
	selectorEmpresa.bindValueToProperty("nombreEmpresa");
	selectorEmpresa.bindItemsToProperty("listaDeNombresDeEmpresas");
	//selectorEmpresa.onSelection(() -> this.getModelObject().buscarEmpresaYSusPeriodos());
    
	//Botón para que se cargue la empresa seleccionada en el viewModel para poder ver
	//los periodos de la misma en el selector.
	Button elegirEmpresa = new Button(panelEvaluar);
	elegirEmpresa.setCaption("Elegir empresa");
	elegirEmpresa.onClick(() -> this.getModelObject().buscarEmpresaYSusPeriodos());
			
	new Label(panelEvaluar); //Para dejar espacio
	new Label(panelEvaluar).setText("Elegir periodo");
	new Label(panelEvaluar); //Para dejar espacio
			
	//Selector para elegir un determinado periodo para una empresa
	Selector<Integer> selectorPeriodo = new Selector<Integer>(panelEvaluar);
	selectorPeriodo.bindValueToProperty("periodoElegido");
	selectorPeriodo.bindItemsToProperty("listaDePeriodosDeEmpresa");
	
    new Label(panelEvaluar); //Para dejar espacio
	new Label(panelEvaluar).setText("Elegir indicador");
	new Label(panelEvaluar); //Para dejar espacio
    
	//Aca se elige el indicador
	Selector<Indicador> selectorIndicador = new Selector<Indicador>(panelEvaluar);
	selectorIndicador.bindValueToProperty("nombreIndicador");
	selectorIndicador.bindItemsToProperty("listaDeNombresDeIndicador");
	
	Button evaluarIndicador = new Button(panelEvaluar);
    evaluarIndicador.setCaption("Evaluar");	
    evaluarIndicador.onClick(()-> this.getModelObject().evaluar());
    
    new Label(panelEvaluar); //Para dejar espacio
    
	new Label(panelEvaluar).setText("Resultado de la evaluación:");
	new Label(panelEvaluar).bindValueToProperty("resultado");
    
	}
	
}
