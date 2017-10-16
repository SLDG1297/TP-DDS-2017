package Modelo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class GestorDeUsuarios {
    private static GestorDeUsuarios ourInstance = new GestorDeUsuarios();

    public static GestorDeUsuarios getInstance() {
        return ourInstance;
    }

    private GestorDeUsuarios() {
    }

    private Map<Integer, UsuarioLogeado> usuariosEnLinea = new HashMap<>();

    private Integer idLibre = 0;

    private Long tiempoDeVidaAsignable = 15L;

    public Integer obtenerId(String email, String passwordHasheada) {

        if(this.esUsuarioValido(email, passwordHasheada))
            return this.idUsuarioLogeado(email);

        return null;

    }

    private Integer idUsuarioLogeado(String email) {
        Integer idAlmacenado = this.idLibre;

        this.usuariosEnLinea.put(idAlmacenado, new UsuarioLogeado(email, LocalDateTime.now().plusMinutes(this.tiempoDeVidaAsignable)));

        idLibre++;

        return idAlmacenado;

    }

    private Boolean esUsuarioValido(String email, String passwordHasheada) {

        return RepositorioUsuarios.getInstancia().buscarObjeto(email).getPasswordHasheada().equals(passwordHasheada);

    }

}
