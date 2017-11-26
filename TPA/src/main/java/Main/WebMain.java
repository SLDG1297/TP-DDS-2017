package Main;

import static spark.Spark.*;
import static spark.Spark.post;
import static spark.SparkBase.port;
import Controllers.EmpresasController;
import Controllers.*;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class WebMain {
	private static HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

    public static void iniciarSitio() {

        port(80);

        staticFileLocation("/public");

        iniciarInterfazWeb();

    }

    private static void iniciarInterfazWeb() {

        iniciarHome();

        iniciarLogin();

        iniciarEmpresas();

        iniciarIndicadores();

        iniciarMetodologias();

    }

    private static void iniciarHome() {

        HomeController homeController = new HomeController();

        get("/", homeController::show, engine);

    }

    public static void iniciarLogin() {

        LoginControllerController loginController = new LoginControllerController();

        get("/login", loginController::show, engine);
        post("/login", loginController::create);
        get("/login-retry", loginController::showFailedLogin, engine);
        post("/login-retry", loginController::create);

    }

    public static void iniciarEmpresas() {

        EmpresasController empresasController = new EmpresasController();

        get("/empresas", empresasController::show, engine);
        post("/empresas",empresasController::seleccionarEmpresa);
        get("/empresas/:nombreEmpresaElegida",empresasController::redireccionarEmpresaElegida, engine);
        post("/empresas/:nombreEmpresaElegida",empresasController::seleccionarPeriodo);
        get("/empresas/:nombreEmpresaElegida/:nombrePeriodoElegido",empresasController::redireccionarPeriodoElegido,engine);
        post("/empresas/:nombreEmpresaElegida/:nombrePeriodoElegido",empresasController::seleccionarPeriodo);
        get("/empresasCreacion", empresasController::creacionEmpresas, engine);

    }

    public static void iniciarIndicadores() {

        iniciarIndicadoresEvaluacion();

        iniciarIndicadoresCreacion();

        iniciarIndicadoresDestruccion();

    }

    public static void iniciarIndicadoresEvaluacion() {

        IndicadoresEvaluacionController indicadoresEvaluacionController = new IndicadoresEvaluacionController();

        get("/indicadores/evaluacion", indicadoresEvaluacionController::show, engine);
        post("/indicadores/evaluacion", indicadoresEvaluacionController::seleccionarIndicador);
        get("/indicadores/evaluacion/:nombreIndicador", indicadoresEvaluacionController::redireccionarIndicadorElegido, engine);
        post("/indicadores/evaluacion/:nombreIndicador", indicadoresEvaluacionController::seleccionarEmpresa);
        get("/indicadores/evaluacion/:nombreIndicador/:nombreEmpresa", indicadoresEvaluacionController::redireccionarEmpresaElegida, engine);
        post("/indicadores/evaluacion/:nombreIndicador/:nombreEmpresa", indicadoresEvaluacionController::seleccionarPeriodo);
        get("/indicadores/evaluacion/:nombreIndicador/:nombreEmpresa/:periodo", indicadoresEvaluacionController::redireccionarPeriodoElegido, engine);

    }

    public static void iniciarIndicadoresCreacion() {

        IndicadoresCreacionController indicadoresCreacionController = new IndicadoresCreacionController();

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

    }

    public static void iniciarIndicadoresDestruccion() {

        IndicadoresDestruccionController indicadoresDestruccionController = new IndicadoresDestruccionController();

        get("/indicadores/destruccion", indicadoresDestruccionController::show, engine);
        post("/indicadores/destruccion", indicadoresDestruccionController::destruir);

    }
    
    public static void iniciarMetodologias() {
    	MetodologiasController metodologiasController = new MetodologiasController();

    	get("/metodologias/comparacion", metodologiasController::listarMetodologias, engine);
    	get("/metodologias/comparacion/:metodologia", metodologiasController::mostrarComparacion, engine);
    }
}
