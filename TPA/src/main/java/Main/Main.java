package Main;

import java.io.IOException;

import Archivo.CargaBatchV2.ConfiguracionCargaBatch;

public class Main {
	public static void main(String[] args) throws IOException {
		/** Original **/
		/*
		Bootstrap.iniciarModelo();
		
		
		WebMain.iniciarSitio();
		*/
		/** Test de Orquestador Batch **/
		/** Cada 1 minuto carga lo que haya en cuentas/cuentitasDeHector.csv **/
		BootstrapV2.iniciarModelo();
		ConfiguracionCargaBatch.iniciar();
	}

}