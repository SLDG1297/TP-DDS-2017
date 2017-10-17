package Main;

import static spark.Spark.*;
import static spark.Spark.post;
import static spark.SparkBase.port;

import java.io.IOException;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.io.FileTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

import Controllers.EmpresasController;
import Modelo.Empresa.Empresa;
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

        get("/", homeController::show, engine);
        get("/login", loginController::show, engine);
        post("/login", loginController::create);
        get("/login-retry", loginController::showFailedLogin, engine);
        post("/login-retry", loginController::create);
        get("/empresas",empresasController::show,engine);
        get("/indicadores/evaluacion",indicadoresEvaluacionController::show,engine);
        
        iniciarMetodologias();
        
        iniciarHandlebarsTemplates();
    }
    
    public static void iniciarMetodologias() {
    	MetodologiasController metodologiasController = new MetodologiasController();
    	
    	get("/metodologias/comparacion", metodologiasController::listarMetodologias, engine);
    	get("/metodologias/comparacion/:metodologia", metodologiasController::mostrarComparacion, engine);
    }
    
    public static void iniciarHandlebarsTemplates() {
    	TemplateLoader loader = new FileTemplateLoader("src/main/resources/templates/Metodologias", ".hbs");
    	
		Handlebars handlebars = new Handlebars(loader);
		
		handlebars.registerHelper("prueba", new Helper<Empresa>() {
			public CharSequence apply(Empresa context, Options options) {
				return "Caca";
			}
		});
		try 
		{
			handlebars.compile("metodologiasResultado");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
    }
}
