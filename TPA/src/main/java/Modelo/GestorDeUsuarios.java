package Modelo;

import spark.Request;

import javax.persistence.NoResultException;
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

        try {

            return RepositorioUsuarios.getInstancia().buscarObjeto(email).getPasswordHasheada().equals(passwordHasheada);

        } catch(NoResultException e) {

            return false;

        }

    }

    public Map<String, String> obtenerMapa(Request request) {
        Map<String, String> mapilla = new HashMap<>();

        mapilla.put("email", GestorDeUsuarios.getInstance().correo(Integer.parseInt(request.cookie("idUser")), request.cookie("email")));

        return mapilla;
    }

    private String correo(Integer id, String email) {

        if(this.usuariosEnLinea.get(id) != null) {
            if (this.usuariosEnLinea.get(id).getEmail().equals(email))
                return email;
        }

        return null;

    }
}
