package Archivo;

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SerializadorJson {
	
	public String serializar(Object object){ //Recibo Object porque quiero que esta clase serialize cualquier objeto
		/*Type type = new TypeToken<Object>(){}.getType(); //uso type por si quiero serializar listas
		Gson gson = new AdaptadorJson().getAdaptador(); //Usamos un adaptador para poder luego deserializar sin probloemas, ya que usamos interfaces
		return gson.toJson(object, type);*/
		return null;
	}

}
