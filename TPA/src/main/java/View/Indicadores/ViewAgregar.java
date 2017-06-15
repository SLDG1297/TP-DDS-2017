package View.Indicadores;

import java.awt.Color;
import java.io.IOException;

import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Modelo.Indicadores.AlmacenIndicadores;
import Modelo.Indicadores.CadenaActualDeMiIndicador;
import Modelo.Indicadores.Division;
import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.Multiplicacion;
import Modelo.Indicadores.Resta;
import Modelo.Indicadores.Suma;
import Modelo.Indicadores.Operacion;

public abstract class ViewAgregar extends Window<VMAgregar> {

	public ViewAgregar(WindowOwner panelPrincipal, VMAgregar VMindicador) {
		super(panelPrincipal, VMindicador);
	}

	// Inicio() y fin() son metodos que todas la view Agregar comparten, cuerpo() no, por eso es abstracta
	@Override
	public void createContents(Panel x) {

		this.inicio(x);
		this.cuerpo(x);
		this.fin(x);

	}

	public void inicio(Panel x) {
		new Label(x).setText("Estado actual del indicador:");
		new Label(x).setBackground(Color.WHITE).bindValueToProperty("miCadena");
		new Label(x); // Espacio
	}

	public void fin(Panel x) {
		/*Panel horizontal1 = new Panel(x);
		horizontal1.setLayout(new HorizontalLayout());
		Panel horizontal2 = new Panel(x);
		horizontal2.setLayout(new HorizontalLayout());*/
		Button suma = new Button(x).setCaption("Sumar");
		Button resta = new Button(x).setCaption("Resta");
		Button multiplicar = new Button(x).setCaption("Multiplicar");
		Button dividir = new Button(x).setCaption("Dividir");
		new Label(x); // Espacio

		Button crear = new Button(x).setCaption("Crear indicador");

		suma.onClick(() -> {
			
			this.efectoBotonOperacion("+", new Suma(getOperandoAnterior()));

		});

		resta.onClick(() -> {
			
			this.efectoBotonOperacion("-", new Resta(getOperandoAnterior()));

		});

		multiplicar.onClick(() -> {
			
			this.efectoBotonOperacion("*", new Multiplicacion(getOperandoAnterior()));

		});

		dividir.onClick(() -> {
			
			this.efectoBotonOperacion("/", new Division(getOperandoAnterior()));

		});

		crear.onClick(() -> {

			this.agregarSegundoOperando();
			this.getModelObject().miIndicadorBuilder.crearIndicador(this.getOperandoAnterior());
			this.mostrarCadena(this.cadena());
			this.mensajeIndicadorCreado();
			CadenaActualDeMiIndicador.instanciar().eliminarCadenaActual();
			try {
				AlmacenIndicadores.almacenarRepositorioIndicadores();
			} catch (IOException e) {
				e.printStackTrace();
			}

		});

	}
	
	//Es el algoritmo/efecto que usan todos botones operacion 
	private void efectoBotonOperacion(String x, Expresion y ){
		this.agregarSegundoOperando();
		this.mostrarCadena(this.cadena());
		this.nuevaOperacion(y);
		this.mostrarCadena(x);
		this.nuevaViewOperando();
	}
	
	//Agrega el Segundo operando a la Operacion Anterior que esta en el Builder(La primera es una Suma, que por el momento tiene una sola expresion que es un 0, aca lo que se hace es agregarle el segundo operando)
	//Este segundo operando es lo que ingresa o selecciona el usuario, por eso eun un metodo abstracto ya que es distinto en cada clase
	private void agregarSegundoOperando() {
		this.getOperandoAnterior().addOperando(this.operacion());
	}
	
	private Expresion getOperandoAnterior(){
		if (this.getModelObject().miIndicadorBuilder.getOperandoAnterior() == null){
			return this.casoBase();
		}else{
		return this.getModelObject().miIndicadorBuilder.getOperandoAnterior();
		}
	}
	
	//Crea una Nueva Operacion, y esta ahora es Operando anterior en el Builder  
	private void nuevaOperacion(Expresion x){
		this.getModelObject().miIndicadorBuilder.setOperandoAnterior(x);
	}
		
	// Es para el manejo de cadenas
	private void mostrarCadena(String string) {
		CadenaActualDeMiIndicador.instanciar().agregar(string);
	}

	private void nuevaViewOperando() {
		new ViewOperando(this, new VMOperando(this.getModelObject().getMiIndicadorBuilder())).open();
	}

	private void mensajeIndicadorCreado() {
		new ViewIndicadorCreado(this, new VMIndicadorCreado()).open();
	}
	
	
	public abstract void cuerpo(Panel x);
	public abstract String cadena(); // Es para el manejo de cadenas particular de cadena de cada view, que son distintas
	public abstract Expresion operacion();
	public abstract Expresion casoBase();

}
