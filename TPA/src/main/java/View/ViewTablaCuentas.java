package View;

import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Cuenta;

public class ViewTablaCuentas extends Window<VMTablaCuentas> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewTablaCuentas(WindowOwner panelGestionar, VMTablaCuentas unaTablaCuentas) {
		super(panelGestionar, unaTablaCuentas);
	}

	@Override
	public void createContents(Panel panelTabla) {
		this.setTitle("Tabla de estado de cuentas de la empresa:");
		
		new Label(panelTabla).setText("Cuentas de la empresa:");
		new Label(panelTabla).bindValueToProperty("nombre");
   
		Table<Cuenta> table = new Table<Cuenta>(panelTabla, Cuenta.class);
		// bindeo lista de cuentas
		table.bindItemsToProperty("listaDeCuentas"); //Representaria la lista de obejtos cuenta de una empresa
	
	   //Las columnas se relacionan con una propiedad 
		
		 new Column<Cuenta>(table) //La propiedad nombre está asociada a una cuenta
	    .setTitle("Nombre")
	    .setFixedSize(150)
	    .bindContentsToProperty("nombre"); 
		
		new Column<Cuenta>(table) //La propiedad valor está asociada a una cuenta
	    .setTitle("Valor")
	    .setFixedSize(150)
	    .bindContentsToProperty("valor");
	}
}
	/*public void createFormPanel(Panel panelTabla){
		
		Table<Cuenta> table = new Table<Cuenta>(panelTabla, Cuenta.class);
		new Column<Cuenta>(table);
		table.setTitle("Cuenta"); // el nombre de la columna
		table.setFixedSize(150); // el tamaño que va a tener
		table.bindContentsToProperty("nombreCuenta");
		new Column<Cuenta>(table);
		table.setTitle("Valor"); // el nombre de la columna
		table.setFixedSize(150); // el tamaño que va a tener
		table.bindContentsToProperty("valorCuenta");
		new Column<Cuenta>(table);
		table.setTitle("Periodo"); // el nombre de la columna
		table.setFixedSize(150); // el tamaño que va a tener
		table.bindContentsToProperty("periodoCuenta");
	}*/
