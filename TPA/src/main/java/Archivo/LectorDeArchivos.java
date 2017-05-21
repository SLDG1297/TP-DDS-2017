package Archivo;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
 
public class LectorDeArchivos {
 
	public InputStream getFile(String path) throws FileNotFoundException {
		return new FileInputStream(path);
	}
	 
}