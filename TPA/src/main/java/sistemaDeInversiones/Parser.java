package sistemaDeInversiones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
	
	public static List<Empresa> aEmpresas(List<List<String>> empresasAParsear) {
		List<Empresa> misEmpresas = new ArrayList<Empresa>();
		
		// PRIMERA PARTE
		
		for(int i = 0; i < empresasAParsear.size(); i++) {
			List<String> empresaAParsear = empresasAParsear.get(i);
			misEmpresas.add(aEmpresa(empresaAParsear));
		}
		
		// SEGUNDA PARTE
		
		misEmpresas = combinarEmpresas(misEmpresas);
		
		return misEmpresas;
	}
	
	public static Empresa aEmpresa(List<String> empresaAParsear) {
		Empresa miEmpresa;
		
		miEmpresa = new Empresa(nombreDeEmpresa(empresaAParsear), periodoDe(empresaAParsear));
		
		return miEmpresa;
	}
		
	private static List<Periodo> periodoDe(List<String> empresaAParsear) {
		List<Periodo> misPeriodos = new ArrayList<Periodo>();
		
		Periodo miPeriodo = new Periodo(anioDePeriodo(empresaAParsear), cuentaDe(empresaAParsear));
		
		misPeriodos.add(miPeriodo);
		
		return misPeriodos;
	}
	
	private static List<Cuenta> cuentaDe(List<String> empresaAParsear) {
		List<Cuenta> misCuentas = new ArrayList<Cuenta>();
		
		Cuenta miCuenta = new Cuenta(nombreDeCuenta(empresaAParsear), valorDeCuenta(empresaAParsear));
		
		misCuentas.add(miCuenta);
		
		return misCuentas;
	}
		
	// Metodos auxiliares PRIMERA PARTE
	
	private static String nombreDeEmpresa(List<String> empresaAParsear) {
		return empresaAParsear.get(0);
	}
	
	private static String nombreDeCuenta(List<String> empresaAParsear) {
		return empresaAParsear.get(1);
	}
	
	private static Integer anioDePeriodo(List<String> empresaAParsear) {
		return Integer.parseInt(empresaAParsear.get(2));
	}

	private static Integer valorDeCuenta(List<String> empresaAParsear) {
		return Integer.parseInt(empresaAParsear.get(3));
	}
	
	// Metodos auxiliares SEGUNDA PARTE
	
	private static List<Empresa> combinarEmpresas(List<Empresa> empresasAParsear) {
		List<Empresa> misEmpresas = new ArrayList<Empresa>();
		
		List<String> nombresDeEmpresa = new ArrayList<String>();
		
		nombresDeEmpresa = obtenerNombresDeEmpresa(empresasAParsear);
		
		misEmpresas = formarEmpresasDefinitivas(nombresDeEmpresa, empresasAParsear);
		
		return misEmpresas;
	}
	
	private static List<String> obtenerNombresDeEmpresa(List<Empresa> empresasAParsear) {
		List<String> nombresDeEmpresa = new ArrayList<String>();
		
		for(int i = 0; i < empresasAParsear.size(); i++) {
			String nombreDeLaEmpresa = empresasAParsear.get(i).getNombre();
			
			if(!nombresDeEmpresa.contains(nombreDeLaEmpresa)) {
				nombresDeEmpresa.add(nombreDeLaEmpresa);
			}
		}
		
		return nombresDeEmpresa;
	}
	
	private static List<Empresa> formarEmpresasDefinitivas(List<String> nombresDeEmpresa, List<Empresa> empresasAParsear) {
		List<Empresa> misEmpresas = new ArrayList<Empresa>();
		
		for(int i = 0; i < nombresDeEmpresa.size(); i++) {
			String nombreDeEmpresa = nombresDeEmpresa.get(i);
			List<Empresa> empresasConMismoNombre = new ArrayList<Empresa>();
			
			empresasConMismoNombre = empresasAParsear.stream().filter(e -> e.getNombre() == nombreDeEmpresa).collect(Collectors.toList());
			
			Empresa empresaDefinitiva = formarEmpresaDefinitiva(empresasConMismoNombre);
			
			misEmpresas.add(empresaDefinitiva);
		}
		
		return misEmpresas;
	}
	
	private static Empresa formarEmpresaDefinitiva(List<Empresa> empresasConMismoNombre) {
		Empresa empresaDefinitiva = new Empresa(empresasConMismoNombre.get(0).getNombre(), formarPeriodos(empresasConMismoNombre));
		
		return empresaDefinitiva;
	}
	
	private static List<Periodo> formarPeriodos(List<Empresa> empresasConMismoNombre) {
		List<Periodo> misPeriodos = new ArrayList<Periodo>();

		for(int i = 0; i < empresasConMismoNombre.size(); i++) {
			
			Periodo periodoActual = empresasConMismoNombre.get(i).getPeriodos().get(0); // .get(0) porque en este momento todas las empresas tienen un solo periodo
			
			Cuenta cuentaActual = periodoActual.getCuentas().get(0); // .get(0) porque en este momento todas las empresas tienen una sola cuenta
			
			boolean contieneElAnio = misPeriodos.stream().anyMatch(p -> p.getAnio().intValue() == periodoActual.getAnio().intValue());
						
			if(contieneElAnio) {
				misPeriodos.get(posicionDeCuentaRespectoAlAnio(misPeriodos, periodoActual.getAnio())).agregarCuenta(cuentaActual);;
			} else {
				misPeriodos.add(new Periodo(periodoActual.getAnio(), periodoActual.getCuentas()));
			}
			
		}
		
		return misPeriodos;
	}
	
	private static Integer posicionDeCuentaRespectoAlAnio(List<Periodo> misPeriodos, Integer anio) {
		Integer posicion;
		
		List<Integer> periodosMapeados = new ArrayList<>();
		
		periodosMapeados = misPeriodos.stream().map(p -> p.getAnio()).collect(Collectors.toList());
		
		posicion = periodosMapeados.indexOf(anio);
		
		return posicion;
	}
	
}
