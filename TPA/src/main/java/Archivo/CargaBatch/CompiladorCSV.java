package Archivo.CargaBatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompiladorCSV {
	private static CompiladorCSV instancia = null;
	public ReceptorDeEmpresas receptor = new ReceptorDeEmpresas();
	
	private CompiladorCSV() { }
	
	public static CompiladorCSV instanciar() {
		if(instancia == null) instancia = new CompiladorCSV();
		
		return instancia;
	}
	
	public ReceptorDeEmpresas getReceptor() {
		return receptor;
	}

	public void setReceptor(ReceptorDeEmpresas receptor) {
		this.receptor = receptor;
	}
	
	public void presentarEmpresas(String ruta) throws IOException {
		FileReader reader = new FileReader(ruta);
		
		BufferedReader buffer = new BufferedReader(reader);
		
		compilar(parsear(buffer));
		
		buffer.close();
		
		reader.close();
	}
	
	public void compilar(List<RenglonCSV> renglones) {
		renglones.stream().forEach(r -> receptor.recibirEmpresa(r));
	}

	public List<RenglonCSV> parsear(BufferedReader buffer) throws IOException {
		String renglon;
		List<RenglonCSV> listaRenglones = new ArrayList<RenglonCSV>();
		
		try
		{
	        while((renglon = buffer.readLine()) != null)
	        {
	        	listaRenglones.add(escanear(renglon));
	        }
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			
		}
        
        return listaRenglones;
	}
	
	public RenglonCSV escanear(String renglon) {
		String[] vector = renglon.split(",");
		
		return new RenglonCSV(vector[0], vector[1], Integer.parseInt(vector[2]), Integer.parseInt(vector[3]));
	}
}
