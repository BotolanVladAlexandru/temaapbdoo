package ro.botolanvlad.APBDOO.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ro.botolanvlad.APBDOO.exceptions.JsonFromObjectException;

@Slf4j
public final class JsonUtil {

    static ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtil() {}

    public static <T> String toJson(final T obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new JsonFromObjectException(e.getMessage(), e);
        }
    }
}
