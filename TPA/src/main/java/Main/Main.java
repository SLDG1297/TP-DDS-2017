package Main;

import java.io.IOException;

import Archivo.CargaBatchV2.DespliegueCargaBatch;

public class Main {
	public static void main(String[] args) throws IOException {
		/** Original **/
		/*
		Bootstrap.iniciarModelo();
		
		
		WebMain.iniciarSitio();
		*/
		/** Test de Orquestador Batch **/
		/** Cada 15 segundos carga lo que haya en cuentas/cuentitasDeHector.csv **/
		BootstrapV2.iniciarModelo();
		DespliegueCargaBatch.iniciar();
	}

}