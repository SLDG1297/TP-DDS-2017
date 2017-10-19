package Modelo.Indicadores;

public class GestorDeDestruccionDeIndicadores {
    private static GestorDeDestruccionDeIndicadores ourInstance = new GestorDeDestruccionDeIndicadores();

    public static GestorDeDestruccionDeIndicadores getInstance() {
        return ourInstance;
    }

    private GestorDeDestruccionDeIndicadores() {
    }



}
