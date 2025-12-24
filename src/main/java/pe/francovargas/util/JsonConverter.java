package pe.francovargas.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    private JsonConverter() {
    }

    public static <T> T fromJson(String fromValue, Class<T> toValueType) {
        try {
            return objectMapper.readValue(fromValue, toValueType);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static String toJson(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

}
