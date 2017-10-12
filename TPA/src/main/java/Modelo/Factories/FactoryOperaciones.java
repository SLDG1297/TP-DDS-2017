package Factories;

import Modelo.Indicadores.Division;
import Modelo.Indicadores.Expresiones;
import Modelo.Indicadores.Multiplicacion;
import Modelo.Indicadores.Parentesis;
import Modelo.Indicadores.Resta;
import Modelo.Indicadores.Suma;

public class FactoryOperaciones {
	public static Suma sumar(Expresiones operandoIzquierdo) {
		return new Suma(operandoIzquierdo);
	}
	
	public static Suma sumar(Expresiones operandoIzquierdo, Expresiones operandoDerecho) {
		return new Suma(operandoIzquierdo, operandoDerecho);
	}
	
	public static Resta restar(Expresiones operandoIzquierdo) {
		return new Resta(operandoIzquierdo);
	}
	
	public static Resta restar(Expresiones operandoIzquierdo, Expresiones operandoDerecho) {
		return new Resta(operandoIzquierdo, operandoDerecho);
	}
	
	public static Multiplicacion multiplicar(Expresiones operandoIzquierdo) {
		return new Multiplicacion(operandoIzquierdo);
	}

	public static Multiplicacion multiplicar(Expresiones operandoIzquierdo, Expresiones operandoDerecho) {
		return new Multiplicacion(operandoIzquierdo, operandoDerecho);
	}
	
	public static Division dividir(Expresiones operandoIzquierdo) {
		return new Division(operandoIzquierdo);
	}
	
	public static Division dividir(Expresiones operandoIzquierdo, Expresiones operandoDerecho) {
		return new Division(operandoIzquierdo, operandoDerecho);
	}
	
	public static Parentesis parentesis(Expresiones expresion) {
		return new Parentesis(expresion);
	}
}
