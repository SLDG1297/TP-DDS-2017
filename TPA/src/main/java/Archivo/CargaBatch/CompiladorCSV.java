package Archivo.CargaBatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Archivo.FileCleaner;

public class CompiladorCSV {
	private static CompiladorCSV instancia = null;
	
	private CompiladorCSV() { }
	
	public static CompiladorCSV instanciar() {
		if(instancia == null) instancia = new CompiladorCSV();
		
		return instancia;
	}
	
	public List<RenglonCSV> compilarEmpresas(String ruta) throws IOException {
		FileReader reader = new FileReader(ruta);
		
		BufferedReader buffer = new BufferedReader(reader);
		
		List<RenglonCSV> renglones = instanciar().parsear(buffer);
		
		buffer.close();
		
		reader.close();
		
		new FileCleaner().limpiar(ruta);
		
		return renglones;
	}
	
	public List<RenglonCSV> parsear(BufferedReader buffer) throws IOException {
		List<RenglonCSV> renglones = new ArrayList<RenglonCSV>();
		
		String renglon;
		
        while((renglon = buffer.readLine())!= null) renglones.add(instanciar().escanear(renglon));
		
		return renglones;
	}
	
	public RenglonCSV escanear(String renglon) {
		String[] vector = renglon.split(",");
		
		return new RenglonCSV(vector[0], vector[1], vector[2], vector[3]);
	}
}
