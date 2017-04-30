package sistemaDeInversiones;

import java.util.List;

public class LeerArchivo {
	public List<Empresas> excel() {
//		return Parser.aEmpresas(List<String> nombresDeEmpresa, List<List<List<List<Integer>>>> cuentasAParsear)
	}
	
	/*
	 * 
	 * Gonza:
	 * 
	 * La idea es que mediante un excel crees:
	 * 
	 * 1) Una lista de nombre de empresas.
	 * 
	 * 2) Una lista de lista de lista de lista de enteros
	 * 
	 * El primer punto es basicamente agarrar todos los nombres de la columna A2 hasta que sea null,
	 * mientras que el segundo punto es formar cuatro listas una dentro de la otra, la cual
	 * la madre de todas ellas es las cuentas de cada empresa (la primer posicion cuenta corresponde a 
	 * la primer posicion nombre de empresa). Dentro de la cuenta van a haber varias listas, las cuales
	 * segun la posicion van a representar un tipo de cuenta (EDITBA, Free Cash Flow). Si una empresa tiene EDITBA
	 * y no tiene FCF, dentro de FCF va a tener como periodos 'null' (no va a tener ningun periodo). Esto me permite
	 * que la lista al siempre tener la misma cantidad de posiciones en el sector de cuentas, sin importar
	 * que una empresa tenga 1, 2, 4, o mismo 0 cuentas, poder saber dependiendo la posicion si es EDITBA, FCF, o
	 * lo que sea (revisa mi codigo cualquier cosa). Luego de esta lista de cuentas, viene la ultima lista, que es
	 * la de Periodos, los cuales poseeran solo dos numeros: Periodo y Año.
	 * 
	 * Comentarios extra:
	 * 
	 * Una celda vacia es 'null'. Claramente, lo unico que puede ser null son los periodos (o sea, que no hay
	 * cuentas hechas con el metodo asociado a la columna) y los nombres de la empresa. Que una empresa tenga null
	 * en el nombre, automaticamente hace que cortes ahi de leer nombres de empresas. Si hector es un pelotudo y te
	 * escribe empresas abajo, es porque es teton y boludo. Si se nos ocurre de alguna forma controlar si realmente
	 * corta ahi, buenisimo. Seguramente hay un metodo que te permita leer todo y sacar de ahi si realmente termino,
	 * pero fijate. Cualquier cosa, yo dejo una excepcion en mi código que es si me mandas más cuentas que empresas
	 * o al reves.
	 * 
	 * Bueno che, medio largo, pero espero que esto te sirva para cuando planees como encaminarlo. Por favor ruego
	 * que fede no me mande a la mierda el codigo. Es una poronga hermosa.
	 * 
	 * Abrazo,
	 * Nachito.
	 * 
	 */
}
