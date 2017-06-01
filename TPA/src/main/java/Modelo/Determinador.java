package Modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Determinador{
        public static BigDecimal determinar(String operando, List<Cuenta> cuentas){
        	
  /*      if(IndicadoresRepository.existeIndicador(operando)){
            Operacion formula = IndicadoresRepository.getIndicador(operando).getFormula();
            return formula.aplicar(cuentas);
        }*/
        
        if(cuentas.stream().map(c -> c.getNombre()).collect(Collectors.toList()).contains(operando)){
            Cuenta cuenta = cuentas.stream().filter(c -> c.getNombre().equals(operando)).collect(Collectors.toList()).get(0);
            return new BigDecimal(cuenta.getValor().toString());
        }
       
        if(esNumeroValido(operando)){
            return new BigDecimal(operando);
        }
        //throw new Exception("Operando no válido");----------------------------------------Ver cómo tratar excepción.
        return new BigDecimal("jaj");
        }
        
        public static boolean esNumeroValido(String s) {
        	try
        	{
        	Integer.parseInt(s.replace(".", ""));
        	// s es un integer valido
        	return true;
        	}
        	catch (NumberFormatException ex)
        	{
        	return false;
        	}
        	}
}
