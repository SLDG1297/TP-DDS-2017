package sistemaDeInversiones;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.io.IOException;
import com.google.gson.Gson;

import org.uqbar.commons.utils.Observable;

@Observable
public class Empresa {
	private String nombre;
	private List<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	public Empresa(String nuevoNombre) {
		nombre = nuevoNombre;
		this.cargarCuentasHardcodeado();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

/*
	private void agregarCuenta(String cuentaJson) {
		cuentas.add(new Gson().fromJson(cuentaJson, Cuenta.class)); // Guardo una Cuenta
	}

	public void cargarCuentasArchivo() {
		try (Stream<String> stream = Files.lines(Paths.get("cuentas.txt"))) {
	        stream.filter(e -> e != null).forEach(cuentaJson -> this.agregarCuenta(cuentaJson));
//			stream.filter(e -> e != null).forEach(System.out::println); // Es para probar si funciona
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			//System.out.println(cuentas.get(0).getNombre());
			e.printStackTrace();
		}
	}
*/
	
	public void cargarCuentasHardcodeado() {
		// Acá se accede al archivo para cargar las cuentas de la empresa.
		// Originalmente pensamos en hacer una clase estática "Bolsa de Valores" para que cargue todo.
		// Pero tratamos de hacer la clase estática y tuvimos problemas...
		// Así que...
		// De momento, esto va a estar hardcodeado con unas cuentas de prueba para visualizar en la vista.
		Cuenta cuenta1 = new Cuenta("EDITBA", 1000, 2010);
		Cuenta cuenta2 = new Cuenta("Free Cash Flow", 2000, 1999);
		cuentas = Arrays.asList(cuenta1, cuenta2);
	}

	public void consultarCuentas() {
		this.getCuentas();
	}
}
