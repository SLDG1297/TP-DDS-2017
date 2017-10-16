package Modelo;

import DB.TipoDeRepositorio;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario implements TipoDeRepositorio {

    @Id
    @GeneratedValue
    @Column(name = "usuario_id")
    private long id;

    @Column(name = "usuario_email")
    private String email;

    @Column(name = "usuario_password_md5")
    private String passwordHasheada;

    public Usuario(String email, String passwordHasheada) {
        this.email = email;
        this.passwordHasheada = passwordHasheada;
    }

    @Override
    public String getNombre() {
        return this.email;
    }

    public String getPasswordHasheada() {
        return passwordHasheada;
    }
}
