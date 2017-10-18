package Modelo.Usuarios;

import DB.TipoDeRepositorio;
import org.uqbar.commons.utils.Observable;

import javax.persistence.*;

@Entity
@Observable
@Table(name = "usuario")
public class Usuario implements TipoDeRepositorio {

    @Id
    @GeneratedValue
    @Column(name = "usuario_id")
    private long id;

    @Column(name = "usuario_email")
    private String nombre;

    @Column(name = "usuario_password_md5")
    private String passwordHasheada;

    public Usuario() {
    }

    public Usuario(String email, String passwordHasheada) {
        this.nombre = email;
        this.passwordHasheada = passwordHasheada;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    public String getEmail() {
        return nombre;
    }

    public String getPasswordHasheada() {
        return passwordHasheada;
    }
}
