package sistemaDeInversiones;

public class Periodo {
	int anio;
	int valor;
	
	public Periodo(int nuevoAnio, int nuevoValor) {
		anio = nuevoAnio;
		valor = nuevoValor;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
