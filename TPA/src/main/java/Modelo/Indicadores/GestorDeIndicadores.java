package Modelo.Indicadores;

import DB.Repositorios.RepositorioIndicadores;

import java.math.BigDecimal;

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

        this.indicadorBuilder.setOperandoAnterior(RepositorioIndicadores.getInstancia().buscarObjeto(nombre));

    }

    public void colocarCuenta(String nombre) {

        this.indicadorBuilder.setOperandoAnterior(new Cuenta_Indicadores(nombre));

    }

    public void colocarNumero(String numero) {

        this.indicadorBuilder.setOperandoAnterior(new Numero(new BigDecimal(numero)));

    }
}
