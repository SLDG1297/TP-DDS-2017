package Modelo.Indicadores;

import DB.Repositorios.RepositorioIndicadores;
import Factories.FactoryOperaciones;

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

    public void agregarOperador(String operadorAAsignar) {

        Operacion operador;

        switch (operadorAAsignar) {

            case "Suma":
                operador = new Suma();
                break;

            case "Resta":
                operador = new Resta();
                break;

            case "Multiplicacion":
                operador = new Multiplicacion();
                break;

            case "Division":
                operador = new Division();
                break;

            default:
                throw new RuntimeException("No se puede construir"); // Hacer excepcion posta

        }

        Expresion expresion = this.indicadorBuilder.getOperandoAnterior();

        expresion.addOperando(operador);

        this.indicadorBuilder.setOperandoAnterior(expresion);

    }

    public String obtenerFormula() {

        return this.indicadorBuilder.imprimirFormula();

    }
}
