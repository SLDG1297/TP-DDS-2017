package sistemaDeInversiones;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;
import com.google.gson.Gson;

import org.uqbar.commons.utils.Observable;

@Observable
public class Empresa {
	private String nombre;
	private List<Cuenta> cuentas;

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
	
	public void agregarCuenta(String cuentaJson) {
		cuentas.add(new Gson().fromJson(cuentaJson, Cuenta.class)); // Guardo una Cuenta
	}

	public void cargarCuentas() {
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

	public void consultarCuentas() {
		this.getCuentas();
	}
}
