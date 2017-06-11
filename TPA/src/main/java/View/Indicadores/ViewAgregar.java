package View.Indicadores;

import java.awt.Color;
import java.io.IOException;

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
		Button suma = new Button(x).setCaption("Sumar");
		Button resta = new Button(x).setCaption("Resta");
		Button multiplicar = new Button(x).setCaption("Multiplicar");
		Button dividir = new Button(x).setCaption("Dividir");
		new Label(x); // Espacio

		Button crear = new Button(x).setCaption("Crear indicador");

		suma.onClick(() -> {

			this.agregarOperando();
			this.mostrarCadena(this.cadena());
			this.getModelObject().miIndicadorBuilder
					.setOperandoAnterior(new Suma(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			this.mostrarCadena("+");
			this.nuevaViewOperando();

		});

		resta.onClick(() -> {

			this.agregarOperando();
			this.mostrarCadena(this.cadena());
			this.getModelObject().miIndicadorBuilder
					.setOperandoAnterior(new Resta(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			this.mostrarCadena("-");
			this.nuevaViewOperando();

		});

		multiplicar.onClick(() -> {

			this.agregarOperando();
			this.mostrarCadena(this.cadena());
			this.getModelObject().miIndicadorBuilder.setOperandoAnterior(
					new Multiplicacion(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			this.mostrarCadena("*");
			this.nuevaViewOperando();

		});

		dividir.onClick(() -> {

			this.agregarOperando();
			this.mostrarCadena(this.cadena());
			this.getModelObject().miIndicadorBuilder
					.setOperandoAnterior(new Division(this.getModelObject().miIndicadorBuilder.getOperandoAnterior()));
			this.mostrarCadena("/");
			this.nuevaViewOperando();

		});

		crear.onClick(() -> {

			this.agregarOperando();
			this.getModelObject().miIndicadorBuilder.crearIndicador();
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

	private void agregarOperando() {
		this.getModelObject().getMiIndicadorBuilder().getOperandoAnterior().addOperando(this.operacion());
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

}
