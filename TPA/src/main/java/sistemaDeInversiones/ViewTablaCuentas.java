package sistemaDeInversiones;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

public class ViewTablaCuentas extends Window<VMTablaCuentas> {

	public ViewTablaCuentas(WindowOwner panelGestionar, VMTablaCuentas unaTablaCuentas) {
		super(panelGestionar, unaTablaCuentas);
	}

	@Override
	public void createContents(Panel panelTabla) {
		this.setTitle("Tabla de estado de cuentas");
		
		//Puse un selector para probar si se pueden ver los nombres de las cuentas cargadas
		Selector<Cuenta> selector = new Selector<Cuenta>(panelTabla);
		selector.bindValueToProperty("nombreCuentaSeleccionada");
		selector.bindItemsToProperty("listaDeNombresDeCuentas");
		
		
		/*Table<Cuenta> table = new Table<Cuenta>(panelTabla, Cuenta.class);
		// bindeo lista de cuentas
		table.bindItemsToProperty("listaDeCuentas"); //Representaria la lista de obejtos cuenta de una empresa
	
	   //Las columnas se relacionan con una propiedad 
		
		 new Column<Cuenta>(table) //La propiedad nombre est� asociada a una cuenta
	    .setTitle("Nombre")
	    .setFixedSize(150)
	    .bindContentsToProperty("nombre"); 
		
		new Column<Cuenta>(table) //La propiedad valor est� asociada a una cuenta
	    .setTitle("Valor")
	    .setFixedSize(150)
	    .bindContentsToProperty("valor");
		
		new Column<Cuenta>(table) //La propiedad periodo est� asociada a una cuenta
	    .setTitle("Periodo")
	    .setFixedSize(150)
	    .bindContentsToProperty("periodo");

	}
	

	/*public void createFormPanel(Panel panelTabla){
		
		Table<Cuenta> table = new Table<Cuenta>(panelTabla, Cuenta.class);
		new Column<Cuenta>(table);
		table.setTitle("Cuenta"); // el nombre de la columna
		table.setFixedSize(150); // el tama�o que va a tener
		table.bindContentsToProperty("nombreCuenta");
		new Column<Cuenta>(table);
		table.setTitle("Valor"); // el nombre de la columna
		table.setFixedSize(150); // el tama�o que va a tener
		table.bindContentsToProperty("valorCuenta");
		new Column<Cuenta>(table);
		table.setTitle("Periodo"); // el nombre de la columna
		table.setFixedSize(150); // el tama�o que va a tener
		table.bindContentsToProperty("periodoCuenta");
	}*/
	}
}
