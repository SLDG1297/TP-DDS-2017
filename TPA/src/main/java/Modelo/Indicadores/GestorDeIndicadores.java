package Modelo.Indicadores;

public class GestorDeIndicadores {
    private static GestorDeIndicadores ourInstance = new GestorDeIndicadores();

    public static GestorDeIndicadores getInstance() {
        return ourInstance;
    }

    private GestorDeIndicadores() {
    }

    IndicadorBuilder indicadorBuilder = new IndicadorBuilder();

    public void nombrar(String nombre) {

        indicadorBuilder.setNombreIndicador(nombre);

    }
}
