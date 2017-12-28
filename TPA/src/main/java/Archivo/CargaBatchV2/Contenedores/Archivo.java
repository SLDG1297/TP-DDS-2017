package Archivo.CargaBatchV2.Contenedores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Archivo.CargaBatchV2.StringScanner;
import Archivo.CargaBatchV2.Contenedor;
import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.ScannerExceptionHandler;

public class Archivo extends Contenedor {
	private String ruta;
	private FileReader reader;
	private BufferedReader buffer;
	private StringScanner scanner;
	
	public Archivo(String ruta, StringScanner scanner, ScannerExceptionHandler manejadorExcepciones) throws FileNotFoundException
	{
		super(manejadorExcepciones);
		this.ruta = ruta;
		this.reader = new FileReader(ruta);
		this.buffer = new BufferedReader(reader);
		this.scanner = scanner;
	}
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public EmpresaToken escanearProximoToken() throws IOException {
		return scanner.escanear(buffer.readLine());
	}

	@Override
	public boolean tieneTokensPendientes() throws IOException {
		return buffer.read() != -1;
	}

	@Override
	public void limpiarse() throws IOException {
		try
		{
			File archivoDeLimpieza = new File(ruta);
			
			BufferedWriter bufferDeLimpieza = new BufferedWriter(new FileWriter(archivoDeLimpieza));

			bufferDeLimpieza.write("");

			bufferDeLimpieza.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			this.cerrarArchivo();
		}
	}
	
	public void cerrarArchivo() throws IOException
	{
		this.buffer.close();
		
		this.reader.close();
	}
}
