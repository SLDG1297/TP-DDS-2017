package Main;

import java.io.IOException;

import Archivo.CargaBatchV2.OrquestadorDeCargaBatch;

public class Main {
	public static void main(String[] args) throws IOException {
		BootstrapV2.iniciarModelo();
		
		/*WebMain.iniciarSitio();*/
		
		OrquestadorDeCargaBatch.iniciar();
	}

}