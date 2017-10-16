package Main;

import static spark.Spark.*;
import static spark.Spark.post;
import static spark.SparkBase.port;

import Controllers.EmpresasController;
import Controllers.HomeController;
import Controllers.LoginController;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class WebMain {

    public static void iniciarInterfazWeb() {

        HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

        LoginController loginController = new LoginController();

        HomeController homeController = new HomeController();

        EmpresasController empresasController = new EmpresasController();

        port(8080);

        staticFileLocation("/public");

        get("/", homeController::show, engine);
        get("/login", loginController::show, engine);
        post("/login", loginController::create);
        get("/login-retry", loginController::showFailedLogin, engine);
        post("/login-retry", loginController::create);
        get("/empresas",empresasController::show,engine);

    }

}
