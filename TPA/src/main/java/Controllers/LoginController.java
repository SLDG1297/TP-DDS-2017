package Controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LoginController {

    public ModelAndView show(Request request, Response response) {
        return new ModelAndView(null, "login.hbs");
    }


    public Void create(Request request, Response response) {

        String email = request.queryParams("email");
        String passwordHasheada = request.queryParams("password");

        // Integer codigoUsuario = GestorDeUsuarios.getInstance().obtenerId(email, passwordHasheada);

        Integer codigoUsuario = null;

        if(codigoUsuario == null)
            response.redirect("/login-retry");
        else {
            response.cookie("email", email);
            response.cookie("idUser", codigoUsuario.toString());
            response.redirect("/");
        }

        return null;
    }

    public ModelAndView showFailedLogin(Request request, Response response) {
        return new ModelAndView(null, "loginRetry.hbs");
    }
}
