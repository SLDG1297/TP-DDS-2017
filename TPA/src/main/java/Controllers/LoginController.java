package Controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Map;

public class LoginController {

    public ModelAndView show(Request request, Response response) {
        return new ModelAndView(null, "login.hbs");
    }


    public Void create(Request request, Response response) {

        String email = request.queryParams("email");
        String password = request.queryParams("password");

        response.cookie("email", email);
        response.cookie("password",password);

        response.redirect("/");

        return null;
    }

}
