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

        this.indicadorBuilder.setNombreIndicador(nombre);

    }

    public void colocarIndicador(String nombre) {

        /*

        TODO

         */

    }


}
