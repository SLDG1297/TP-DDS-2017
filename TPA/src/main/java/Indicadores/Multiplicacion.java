package Indicadores;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Modelo.Cuenta;

public class Multiplicacion implements Operacion{
	
	List<String> operandos = new ArrayList<String>();
	
	public Multiplicacion(String [] misOperandos) {
		Stream<String> streamDeMisOperandos = Arrays.stream(misOperandos);
		streamDeMisOperandos.forEach(o -> operandos.add(o));
	}
	
	public Multiplicacion(List<String> misOperandos) {
		operandos = misOperandos;
	}
	
	public BigDecimal aplicar(List <Cuenta> cuentas){
		BigDecimal valorFinal;
		List<BigDecimal> valoresDeMisOperandos = new ArrayList<BigDecimal>();
		
		valoresDeMisOperandos = operandos.stream().map(o -> Determinador.determinar(o, cuentas)).collect(Collectors.toList());
		
		valorFinal = valoresDeMisOperandos.stream().reduce(new BigDecimal(0), (valorA, valorB) -> valorA.multiply(valorB));
		
		return valorFinal;
	}

}