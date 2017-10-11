package Controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class HomeController {

    public ModelAndView show(Request request, Response response) {

        System.out.println(request.cookies());

        return new ModelAndView(null, "home.hbs");

    }

}
