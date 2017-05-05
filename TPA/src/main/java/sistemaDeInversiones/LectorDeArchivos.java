package sistemaDeInversiones;
 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
public abstract class LectorDeArchivos {
 
    public static List<List<String>> listaFinal = new ArrayList<List<String>>();;
    
    public static List<List<String>> entregarLista() {
 
        BufferedReader bufferLectura = null;
        try {
            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader("cuentitasDeHector.csv"));//Esta es la ruta del archivo creado
 
            // Leer una linea del archivo
            String linea = bufferLectura.readLine();
 
            while (linea != null) {
                // Split toma string hasta donde aparezca una "," y los mete en una posicion del array
                String[] array = linea.split(",");
                //Creo una lista de string
                List<String> lista = new ArrayList<String>();
                //Meto los String del array en la lista de String
                for (int i= 0; i < array.length; i++ ){
                	lista.add(array[i]);
                }
                	 //Meto la lista(que representa una empresa, cuenta, valor y periodo) dentro de la lista que contendra listas de string
                    listaFinal.add(lista);
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
        return listaFinal;
    }
 
 
}