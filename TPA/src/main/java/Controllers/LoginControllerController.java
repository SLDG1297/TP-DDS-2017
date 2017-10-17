package Controllers;

import Modelo.GestorDeUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class LoginControllerController {

    public ModelAndView show(Request request, Response response) {

        if(GestorDeUsuarios.getInstance().obtenerMapa(request).get("email") != null)
            return new ModelAndView(GestorDeUsuarios.getInstance().obtenerMapa(request), "yaLogeado.hbs");

        return new ModelAndView(GestorDeUsuarios.getInstance().obtenerMapa(request), "login.hbs");
    }

    public Void create(Request request, Response response) {

        String email = request.queryParams("email");
        String passwordHasheada = request.queryParams("password");

        Integer codigoUsuario = GestorDeUsuarios.getInstance().obtenerId(email, passwordHasheada);

        /*
        "axel@bags.com", "axel"
         */

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

        if(GestorDeUsuarios.getInstance().obtenerMapa(request).get("email") != null)
            return new ModelAndView(GestorDeUsuarios.getInstance().obtenerMapa(request), "yaLogeado.hbs");

        return new ModelAndView(GestorDeUsuarios.getInstance().obtenerMapa(request), "loginRetry.hbs");
    }

}
