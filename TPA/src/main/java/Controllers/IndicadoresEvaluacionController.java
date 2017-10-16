package Controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class IndicadoresEvaluacionController {

	   public ModelAndView show(Request request, Response response){

			return new ModelAndView(null,"indicadoresEvaluacion.hbs");

		    }
	
}
