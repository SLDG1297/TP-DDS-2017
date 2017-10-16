package Main;

import static spark.Spark.*;
import static spark.Spark.post;
import static spark.SparkBase.port;

import Controllers.EmpresasController;
import Controllers.*;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class WebMain {
	private static HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

    public static void iniciarInterfazWeb() {
        
        LoginController loginController = new LoginController();

        HomeController homeController = new HomeController();

        EmpresasController empresasController = new EmpresasController();
        
        IndicadoresEvaluacionController indicadoresEvaluacionController = new IndicadoresEvaluacionController();

        port(8080);

        staticFileLocation("/public");

        get("/login", loginController::show, engine);
        get("/empresas",empresasController::show, engine);
        get("/indicadores/evaluacion",indicadoresEvaluacionController::show, engine);
        post("/login", loginController::create);
        get("/", homeController::show, engine);

    }
    
    public static void iniciarMetodologias() {
    	MetodologiasController metodologiasController = new MetodologiasController();
    	
    	get("/metodologias", metodologiasController::listar, engine);
    }

}
