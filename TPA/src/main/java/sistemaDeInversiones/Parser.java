package sistemaDeInversiones;

import java.util.ArrayList;
import java.util.List;

public class Parser {
	
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
}
