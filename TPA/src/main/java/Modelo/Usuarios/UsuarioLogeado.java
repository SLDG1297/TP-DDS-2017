package Modelo.Usuarios;

import java.time.LocalDateTime;

public class UsuarioLogeado {

    private String email;
    private LocalDateTime cuandoExpira;

    public UsuarioLogeado(String email, LocalDateTime cuandoExpira) {
        this.email = email;
        this.cuandoExpira = cuandoExpira;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCuandoExpira() {
        return cuandoExpira;
    }
}
