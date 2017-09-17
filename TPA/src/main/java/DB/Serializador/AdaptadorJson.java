package DB.Serializador;

import Modelo.Empresa.Cuenta;
import Modelo.Indicadores.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AdaptadorJson {

    private RuntimeTypeAdapterFactory<Expresiones> adapter(){
        RuntimeTypeAdapterFactory<Expresiones> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Expresiones.class, "type")
                .registerSubtype(Suma.class, "Suma")
                .registerSubtype(Resta.class, "Resta")
                .registerSubtype(Numero.class, "Numero")
                .registerSubtype(Indicador.class, "Indicador")
                .registerSubtype(Division.class, "Division")
                .registerSubtype(Multiplicacion.class, "Multiplicacion")
                .registerSubtype(Cuenta_Indicadores.class, "Cuenta");
        return runtimeTypeAdapterFactory;
    }

    public Gson getAdaptador(){
        return new GsonBuilder().registerTypeAdapterFactory(this.adapter()).create();
    }

}
