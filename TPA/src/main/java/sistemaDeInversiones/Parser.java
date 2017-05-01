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
		
		nombresDeEmpresa = obtenerNombresDeEmpresa(misEmpresas);
		
		misEmpresas = formarEmpresasDefinitivas(nombresDeEmpresa, misEmpresas);
		
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
			
			Periodo periodoActual = empresasConMismoNombre.get(i).getPeriodos().get(0);
			
			boolean contieneElAnio = misPeriodos.stream().anyMatch(p -> p.getAnio() == periodoActual.getAnio());
			
			if(contieneElAnio) {
				Periodo periodoDeMisPeriodos = misPeriodos.stream().
						filter(p -> periodoActual.getAnio() == p.getAnio()).
						collect(Collectors.toList()).get(0);
				
				periodoDeMisPeriodos.cuentas.add(periodoActual.getCuentas().get(0));
			} else {
				misPeriodos.add(new Periodo(periodoActual.getAnio(), periodoActual.getCuentas()));
			}
			
		}
		
		return misPeriodos;
	}
	
	/*
	public List<Empresa> aEmpresas(List<String> nombresDeEmpresa, List<List<List<List<Integer>>>> cuentasAParsear) {
		
		this.elInputEstaCorrectamenteEscrito(nombresDeEmpresa, cuentasAParsear);
		
		List<Empresa> misEmpresas = new ArrayList<Empresa>();

		for(char i = 0; i < nombresDeEmpresa.size(); i++) {
			misEmpresas.add(this.aEmpresa(nombresDeEmpresa.get(i), cuentasAParsear.get(i)));
		}
		
		return misEmpresas;
	}
	
	private Empresa aEmpresa(String nombreDeEmpresa, List<List<List<Integer>>> cuentasAParsear) {
		Empresa miEmpresa;
		
		miEmpresa = new Empresa(nombreDeEmpresa, this.aCuentas(cuentasAParsear));
		return miEmpresa;
	}
	
	private List<Cuenta> aCuentas(List<List<List<Integer>>> cuentasAParsear) {
		List<Cuenta> misCuentas = new ArrayList<Cuenta>();
				
		for(char i = 0; i < cuentasAParsear.size(); i++) {
			List<List<Integer>> periodosAParsear = cuentasAParsear.get(i);
			if(this.tienePeriodos(periodosAParsear)) {
				misCuentas.add(new Cuenta(this.nombreDeCuenta(i), this.aPeriodos(periodosAParsear)));				
			}
		}
		
		return misCuentas;
	}
	
	private List<Periodo> aPeriodos(List<List<Integer>> periodosAParsear) {
		List<Periodo> misPeriodos = new ArrayList<Periodo>();
		
		for(char i = 0; i < periodosAParsear.size(); i++) {
			misPeriodos.add(new Periodo(periodosAParsear.get(i).get(0), periodosAParsear.get(i).get(1)));
		}
		
		return misPeriodos;
	}
	
	// Metodos auxiliares
	
	private String nombreDeCuenta(char i) {
		switch(i) {
			case 0:
				return "EDITBA";
			case 1:
				return "Free Cash Flow";
		}
		
		return "lepra";
	}
	
	private boolean tieneAlMenosUnaCuenta(List<List<List<Integer>>> cuenta) {
		boolean valor = true;
		
		for(char i = 0; i < cuenta.size(); i++) {
			valor &= this.tienePeriodos(cuenta.get(i));
		}
		
		return valor;
	}
	
	private boolean tienePeriodos(List<List<Integer>> periodo) {
		return periodo != null; // Tengo en cuenta que una celda vacia es igual a null
	}
	
	private boolean elNombreEstaBienEscrito(String nombre) {
		return nombre != null; // Tengo en cuenta que una celda vacia es igual a null
	}
	
	private void elInputEstaCorrectamenteEscrito(List<String> nombresDeEmpresa, List<List<List<List<Integer>>>> cuentasAParsear) {
		boolean mismaCantidadDeEmpresasQueDeCuentas = nombresDeEmpresa.size() == cuentasAParsear.size();

		if(!mismaCantidadDeEmpresasQueDeCuentas) {
			throw new NoHayLaMismaCantidadDeEmpresasQueDeCuentasException();
		}
		
		boolean losNombresDeEmpresasEstanBienEscritos = true;
		
		for(char i = 0; i < nombresDeEmpresa.size(); i++) {
			losNombresDeEmpresasEstanBienEscritos &= this.elNombreEstaBienEscrito(nombresDeEmpresa.get(i));
		}
		
		if(!losNombresDeEmpresasEstanBienEscritos) {
			throw new LasEmpresasNoTienenNombreValidoException();
		}

		boolean todasTienenAlMenosUnaCuenta = true;
		
		for(char i = 0; i < nombresDeEmpresa.size(); i++) {
			todasTienenAlMenosUnaCuenta &= this.tieneAlMenosUnaCuenta(cuentasAParsear.get(i));
		}
		
		if(!todasTienenAlMenosUnaCuenta) {
			throw new LaEmpresaNoTieneCuentasException();
		}
	}
	*/
}
