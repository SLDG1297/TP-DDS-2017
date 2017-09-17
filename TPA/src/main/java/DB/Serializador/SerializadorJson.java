package DB.Serializador;

import DB.Excepciones.SerializacionException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.util.List;

public class SerializadorJson {

    private static SerializadorJson ourInstance = new SerializadorJson();

    ObjectMapper mapper;

    private SerializadorJson() {
        mapper = new ObjectMapper();
    }

    public static SerializadorJson getInstance() {
        return ourInstance;
    }

    public <T> String serializar(T clase) {
        String json;

        try {
            json = new ObjectMapper().writeValueAsString(clase);
        } catch (IOException e) {
            throw new SerializacionException(e, "No se pudo serializar el objeto %s", clase.toString());
        }


        return json;
    }

    public <T> T deserializar(String json, Class<T> clase) {
        T objetoAEntregar;

        try {
            objetoAEntregar = mapper.readValue(json, clase);
        } catch (IOException e) {
            throw new SerializacionException(e, "No se pudo deserializar el json %s", json);
        }

        return objetoAEntregar;
    }


    public <T> List<T> deserializar(String json, TypeReference tipo) {
        List<T> objetosAEntregar;

        try {
            objetosAEntregar = mapper.readValue(json, tipo);
        } catch (IOException e) {
            throw new SerializacionException(e, "No se pudo deserializar el json como lista %s", json);
        }

        return objetosAEntregar;
    }

}
