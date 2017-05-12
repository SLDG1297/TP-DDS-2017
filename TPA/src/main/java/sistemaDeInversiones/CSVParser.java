package sistemaDeInversiones;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

public class CSVParser {
	
	private String separador;
	
	CSVParser(String miSeparador) {
		separador = miSeparador;
	}
		
	public List<Empresa> parse(InputStream stream){
		List<Empresa> empresas = new ArrayList<Empresa>();
		try{
			
			BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
			empresas = (List<Empresa>) buffer.lines()
					.map(line -> Arrays.asList(line.split(this.separador)))
				       .map(line -> new Empresa(line.get(0), line.get(1), line.get(2), line.get(3)) //Lo que pasa aca es que get 2 y 3 siguen siendo String nachito, hay que hacer un metodo aEmpresas como el que tenia que tranformaba los string en periodos y valores, tal cokmo lo especifico el ayudante en los comentarios
				       .collect(Collectors.toList()));
			
			
		}catch (IOException e){}

		List<Empresa> empresasDefinitivas = new ArrayList<Empresa>();
		empresasDefinitivas = this.combinarEmpresas(empresasAParsear);
		
		return empresasDefinitivas;
	}
	
	
	
	private List<Empresa> combinarEmpresas(List<Empresa> empresasAParsear) {
		List<Empresa> misEmpresas = new ArrayList<Empresa>();
		
		List<String> nombresDeEmpresa = new ArrayList<String>();
		
		nombresDeEmpresa = this.obtenerNombresDeEmpresa(empresasAParsear);
		
		misEmpresas = this.formarEmpresasDefinitivas(nombresDeEmpresa, empresasAParsear);
		
		return misEmpresas;
	}
	
	private List<String> obtenerNombresDeEmpresa(List<Empresa> empresasAParsear) {
		List<String> nombresDeEmpresa = new ArrayList<String>();
		
		for(int i = 0; i < empresasAParsear.size(); i++) {
			String nombreDeLaEmpresa = empresasAParsear.get(i).getNombre();
			
			if(!nombresDeEmpresa.contains(nombreDeLaEmpresa)) {
				nombresDeEmpresa.add(nombreDeLaEmpresa);
			}
		}
		
		return nombresDeEmpresa;
	}
	
	private List<Empresa> formarEmpresasDefinitivas(List<String> nombresDeEmpresa, List<Empresa> empresasAParsear) {
		List<Empresa> misEmpresas = new ArrayList<Empresa>();
		
		for(int i = 0; i < nombresDeEmpresa.size(); i++) {
			String nombreDeEmpresa = nombresDeEmpresa.get(i);
			List<Empresa> empresasConMismoNombre = new ArrayList<Empresa>();
			
			empresasConMismoNombre = empresasAParsear.stream().filter(e -> e.getNombre() == nombreDeEmpresa).collect(Collectors.toList());
			
			Empresa empresaDefinitiva = this.formarEmpresaDefinitiva(empresasConMismoNombre);
			
			misEmpresas.add(empresaDefinitiva);
		}
		
		return misEmpresas;
	}
	
	private Empresa formarEmpresaDefinitiva(List<Empresa> empresasConMismoNombre) {
		Empresa empresaDefinitiva = new Empresa(empresasConMismoNombre.get(0).getNombre(), this.formarPeriodos(empresasConMismoNombre));
		
		return empresaDefinitiva;
	}
	
	private List<Periodo> formarPeriodos(List<Empresa> empresasConMismoNombre) {
		List<Periodo> misPeriodos = new ArrayList<Periodo>();

		for(int i = 0; i < empresasConMismoNombre.size(); i++) {
			
			Periodo periodoActual = empresasConMismoNombre.get(i).getPeriodos().get(0); // .get(0) porque en este momento todas las empresas tienen un solo periodo
			
			Cuenta cuentaActual = periodoActual.getCuentas().get(0); // .get(0) porque en este momento todas las empresas tienen una sola cuenta
			
			boolean contieneElAnio = misPeriodos.stream().anyMatch(p -> p.getAnio().intValue() == periodoActual.getAnio().intValue());
						
			if(contieneElAnio) {
				misPeriodos.get(this.posicionDeCuentaRespectoAlAnio(misPeriodos, periodoActual.getAnio())).agregarCuenta(cuentaActual);
			} else {
				misPeriodos.add(new Periodo(periodoActual.getAnio(), periodoActual.getCuentas()));
			}
			
		}
		
		return misPeriodos;
	}
	
	private Integer posicionDeCuentaRespectoAlAnio(List<Periodo> misPeriodos, Integer anio) {
		Integer posicion;
		
		List<Integer> periodosMapeados = new ArrayList<>();
		
		periodosMapeados = misPeriodos.stream().map(p -> p.getAnio()).collect(Collectors.toList());
		
		posicion = periodosMapeados.indexOf(anio);
		
		return posicion;
	}
	
}
