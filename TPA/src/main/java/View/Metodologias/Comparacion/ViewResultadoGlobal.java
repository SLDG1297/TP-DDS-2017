package View.Metodologias.Comparacion;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Metodologias.Resultados.ResultadoAdapterView;

public class ViewResultadoGlobal extends Window<VMResultadoGlobal>  {
		
		public ViewResultadoGlobal(WindowOwner panelPrincipal, VMResultadoGlobal vmResultadoGlobal) {
			super(panelPrincipal, vmResultadoGlobal);
		}

		@Override
		public void createContents(Panel panelPrincipal) {
			
			this.setTitle("Resultado de la evaluacion");
			
			Table<ResultadoAdapterView> table = new Table<ResultadoAdapterView>(panelPrincipal, ResultadoAdapterView.class);
			// bindeo lista 
			table.bindItemsToProperty("listaResultadosAdapter");
			
		
		   //Las columnas se relacionan con una propiedad 
			
			 new Column<ResultadoAdapterView>(table) 
		    .setTitle("Empresa a evaluar")
		    .setFixedSize(300)
		    .bindContentsToProperty("empresaA"); 
			
			new Column<ResultadoAdapterView>(table) 
		    .setTitle("Metodologia con la que se evalua")
		    .setFixedSize(300)
		    .bindContentsToProperty("metodologia");
			
			new Column<ResultadoAdapterView>(table) 
		    .setTitle("Resultado")
		    .setFixedSize(300)
		    .bindContentsToProperty("evaluacion");
			
				
		}
		
}