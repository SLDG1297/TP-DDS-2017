import org.uqbar.commons.utils.Observable;

@Observable
public class Alumno { // De todos estos atributos hay que eliminar los que sean calculables, no olvidar que son provisorios
	
	private AlumnoJson alu;
	private String token;
	private String asignacion;
	private int notasDeAsignacion;
	public int legajo;
	public String nombre;
	public String apellido;
	public String ghu;

	public void llenarDatos() {
		alu = RequestService.obtenerDatosDeAlumno(token);
		legajo = alu.getCode();
		nombre = alu.getFirst_name();
		apellido = alu.getLast_name();
		ghu = alu.getGithub_user();
	}

	public void nothing() { // Método parásito para poder bindear el onClick del
							// botón de mi modelo, hay que modificarlo y
							// hacer que onClick tenga una acción que nos de las
							// notas
		this.setNotasDeAsignacion(2);
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGhu() {
		return ghu;
	}

	public void setGhu(String ghu) {
		this.ghu = ghu;
	}

	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getNotasDeAsignacion() {
		return notasDeAsignacion;
	}

	public void setNotasDeAsignacion(int notasDeAsignacion) {
		this.notasDeAsignacion = notasDeAsignacion;
	}

	public String getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(String asignacion) {
		this.asignacion = asignacion;
	}


}