package DB.Converter;

import DB.Serializador.SerializadorJson;
import Modelo.Indicadores.Expresiones;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class IndicadorConverter implements AttributeConverter<Expresiones, String> {

    @Override
    public String convertToDatabaseColumn(Expresiones expresiones) {

        return SerializadorJson.getInstance().serializar(expresiones);

    }

    @Override
    public Expresiones convertToEntityAttribute(String expresiones) {

        return SerializadorJson.getInstance().deserializar(expresiones, Expresiones.class);

    }

}