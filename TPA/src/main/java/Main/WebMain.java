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
        LoginControllerController loginController = new LoginControllerController();

        HomeController homeController = new HomeController();

        EmpresasController empresasController = new EmpresasController();
        
        IndicadoresEvaluacionController indicadoresEvaluacionController = new IndicadoresEvaluacionController();

        IndicadoresCreacionController indicadoresCreacionController = new IndicadoresCreacionController();

        IndicadoresDestruccionController indicadoresDestruccionController = new IndicadoresDestruccionController();

        port(8080);

        staticFileLocation("/public");

        get("/", homeController::show, engine);
        get("/login", loginController::show, engine);
        post("/login", loginController::create);
        get("/login-retry", loginController::showFailedLogin, engine);
        post("/login-retry", loginController::create);
        
        get("/empresas", empresasController::show, engine);
        
        get("/indicadores/evaluacion", indicadoresEvaluacionController::show, engine);
        post("/indicadores/evaluacion", indicadoresEvaluacionController::seleccionarIndicador);
        get("/indicadores/evaluacion/:nombreIndicador", indicadoresEvaluacionController::redireccionarIndicadorElegido, engine);
        post("/indicadores/evaluacion/:nombreIndicador", indicadoresEvaluacionController::seleccionarEmpresa);
        get("/indicadores/evaluacion/:nombreIndicador/:nombreEmpresa", indicadoresEvaluacionController::redireccionarEmpresaElegida, engine);
        post("/indicadores/evaluacion/:nombreIndicador/:nombreEmpresa", indicadoresEvaluacionController::seleccionarPeriodo);
        get("/indicadores/evaluacion/:nombreIndicador/:nombreEmpresa/:periodo", indicadoresEvaluacionController::redireccionarPeriodoElegido, engine);

        get("/indicadores/creacion", indicadoresCreacionController::show, engine);
        post("/indicadores/creacion", indicadoresCreacionController::redireccionarCreacion);
        get("/indicadores/creacion/:nombre", indicadoresCreacionController::colocarOperando, engine);
        post("/indicadores/creacion/:nombre", indicadoresCreacionController::operandoColocado);
        get("/indicadores/creacion/:nombre/Indicador", indicadoresCreacionController::colocarIndicador, engine);
        post("/indicadores/creacion/:nombre/Indicador", indicadoresCreacionController::redireccionarOperadorDesdeIndicador);
        get("/indicadores/creacion/:nombre/Cuenta", indicadoresCreacionController::colocarCuenta, engine);
        post("/indicadores/creacion/:nombre/Cuenta", indicadoresCreacionController::redireccionarOperadorDesdeCuenta);
        get("/indicadores/creacion/:nombre/Numero", indicadoresCreacionController::colocarNumero, engine);
        post("/indicadores/creacion/:nombre/Numero", indicadoresCreacionController::redireccionarOperadorDesdeNumero);
        get("/indicadores/creacion/:nombre/operadores", indicadoresCreacionController::mostrarOperadores, engine);
        post("/indicadores/creacion/:nombre/operadores", indicadoresCreacionController::redireccionarOperadorElegido);
        get("/indicadores/creacion/:nombre/creado", indicadoresCreacionController::crearIndicador, engine);

        get("/indicadores/destruccion", indicadoresDestruccionController::show, engine);
        post("/indicadores/destruccion", indicadoresDestruccionController::destruir);

        iniciarMetodologias();
    }
    
    public static void iniciarMetodologias() {
    	MetodologiasController metodologiasController = new MetodologiasController();

    	get("/metodologias/comparacion", metodologiasController::listarMetodologias, engine);
    	get("/metodologias/comparacion/:metodologia", metodologiasController::mostrarComparacion, engine);
    }
}
