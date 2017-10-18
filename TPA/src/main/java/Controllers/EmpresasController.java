package Controllers;

import Modelo.Usuarios.GestorDeUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class EmpresasController {

    public ModelAndView show(Request request, Response response){

    return new ModelAndView(GestorDeUsuarios.getInstance().obtenerMapa(request),"empresas.hbs");

    }

}
