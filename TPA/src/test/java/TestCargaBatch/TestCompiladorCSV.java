package TestCargaBatch;

import org.junit.Test;

import Archivo.CargaBatch.RenglonCSV;
import Archivo.CargaBatch.CompiladorCSV;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;

public class TestCompiladorCSV {
	@Test
	public void sePuedeEscanear() {
		String renglon = "Rolito,EDITBA,2000,8000";
		
		RenglonCSV token = CompiladorCSV.instanciar().escanear(renglon);
		
		assertEquals("Rolito", token.getEmpresa().getNombre());
		assertEquals("EDITBA", token.getCuenta().getNombre());
		assertEquals(new Integer(2000), token.getPeriodo().getAnio());
		assertEquals(new Integer(8000), token.getValor());
	}

	@Test
	public void sePuedeParsear() throws IOException {
		String renglones = "Rolito,EDITBA,2000,8000\nRolito,EDITBA,2001,8005\nRolito,EDITBA,2002,9000";
		
		Reader reader = new StringReader(renglones);
		
		BufferedReader buffer = new BufferedReader(reader);
		
		List<RenglonCSV> tokens = CompiladorCSV.instanciar().parsear(buffer);
		
		buffer.close();
		
		reader.close();
		
		assertEquals(tokens.get(0).getEmpresa().getNombre(), "Rolito");
		assertEquals(tokens.get(1).getPeriodo().getAnio(), new Integer(2001));
		assertEquals(tokens.get(2).getCuenta().getNombre(), "EDITBA");
		assertEquals(tokens.get(0).getCuenta().getValor(), new Integer(8000));
	}
}
