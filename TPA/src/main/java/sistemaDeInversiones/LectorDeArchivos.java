package sistemaDeInversiones;
 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
 
public class LectorDeArchivos {
   
   
 
    public static final String SEPARADOR = ",";
    public static final String QUOTE = "\"";
 
    public static void main(String[] args) {
 
        BufferedReader bufferLectura = null;
        try {
            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader("cuentitasDeHector.csv"));//Esta es la ruta del archivo creado
 
            // Leer una linea del archivo
            String linea = bufferLectura.readLine();
 
            while (linea != null) {
                // Separar la linea leída con el separador definido previamente
                String[] campos = linea.split(SEPARADOR);
 
                campos = removeTrailingQuotes(campos);
 
                System.out.println(Arrays.toString(campos));
 
                // Volver a leer otra línea del fichero
                linea = bufferLectura.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cierro el buffer de lectura
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
 
    private static String[] removeTrailingQuotes(String[] fields) {
 
        String result[] = new String[fields.length];
 
        for (int i = 0; i < result.length; i++) {
            result[i] = fields[i].replaceAll("^" + QUOTE, "").replaceAll(QUOTE + "$", "");
        }
        return result;
    }
 
}