package View.Indicadores;


import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;
import Modelo.Indicadores.Expresion;

public class ViewAgregarCuenta extends ViewAgregar {


	public ViewAgregarCuenta(WindowOwner panelPrincipal, VMAgregar vmAgregarCuenta) {
		super(panelPrincipal, vmAgregarCuenta);
	}
	
	
	
	public void cuerpo(Panel x){
		
		new Label(x).setText("Escriba el nuevo operando cuenta");
		new Label(x).setText("(La cuenta debe existir en el sistema)");
		
		new TextBox(x).bindValueToProperty("cuentaElegida");
		
	}

	public String cadena(){
		return this.getModelObject().getCuentaElegida();
	}
	
	public Expresion operacion(){
		return this.getModelObject().devolverCuenta();
	}
	
}