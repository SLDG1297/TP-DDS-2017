package View.Metodologias;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Empresa.Cuenta;
import Modelo.Metodologias.Resultados.ResultadoAdapterView;

public class ViewResultadoMultiple extends Window<VMResultadoMultiple>  {
		
		public ViewResultadoMultiple(WindowOwner panelPrincipal, VMResultadoMultiple vmResultadoMultiple) {
			super(panelPrincipal, vmResultadoMultiple);
		}

		@Override
		public void createContents(Panel panelPrincipal) {
			
			this.setTitle("Resultado de la evaluacion");
			
			Table<ResultadoAdapterView> table = new Table<ResultadoAdapterView>(panelPrincipal, ResultadoAdapterView.class);
			// bindeo lista 
			table.bindItemsToProperty("listaResultadosAdapter");
			
		
		   //Las columnas se relacionan con una propiedad 
			
			 new Column<ResultadoAdapterView>(table) 
		    .setTitle("Empresa a comparar")
		    .setFixedSize(300)
		    .bindContentsToProperty("empresaA"); 
			
			new Column<ResultadoAdapterView>(table) 
		    .setTitle("Empresa con la que se compara")
		    .setFixedSize(300)
		    .bindContentsToProperty("empresaAComparar");
			
			new Column<ResultadoAdapterView>(table) 
		    .setTitle("Resultado")
		    .setFixedSize(300)
		    .bindContentsToProperty("resultado");
			
				
		}
		
}