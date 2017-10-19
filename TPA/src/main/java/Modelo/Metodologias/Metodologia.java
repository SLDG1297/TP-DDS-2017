package Modelo.Metodologias;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import DB.TipoDeRepositorio;
import Modelo.Empresa.Empresa;
import Modelo.Metodologias.Condiciones.Condiciones;
import Modelo.Usuarios.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "metodologia")
public class Metodologia implements TipoDeRepositorio {

	@Id
	@GeneratedValue
	@Column(name = "metolodogia_id")
	private long id_metodologia;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name = "metodologia_fk_id",  referencedColumnName = "metolodogia_id")
	private List<Condiciones> listaCondiciones = new ArrayList<Condiciones>();
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_fk_id")
	private Usuario usuario;
	
	public Metodologia(String nombre, Usuario usuario, List<Condiciones> condiciones){
		this.setUsuario(usuario);
		this.setNombre(nombre);
		this.setListaCondiciones(condiciones);
	}
	
	public Metodologia(String nombre, List<Condiciones> condiciones){
		this.setNombre(nombre);
		this.setListaCondiciones(condiciones);
	}
	
	public Metodologia(String nombre, Condiciones condicion) {
		this.setNombre(nombre);
		this.addCondicion(condicion);
	}

	@SuppressWarnings("unused")
	private Metodologia() {}
	
	public long getId_metodologia() {
		return id_metodologia;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Condiciones> getListaCondiciones() {
		return listaCondiciones;
	}
	
	public void setListaCondiciones(List<Condiciones> listaCondiciones) {
		this.listaCondiciones = listaCondiciones;
	}

	public void addCondicion(Condiciones condicion){
		listaCondiciones.add(condicion);
	}
	
	public boolean cumple(Empresa empresa){
		return listaCondiciones.stream().allMatch(condicion -> condicion.cumple(empresa));
	}
	
	public String getCadena() {
		return String.join(" && ", listaCondiciones.stream().map(c -> c.mostrarCadena()).collect(Collectors.toList()));
	}

}
