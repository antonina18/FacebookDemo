package ksowka.demo.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import ksowka.demo.models.Facebook;

import java.io.IOException;

public class JsonParser {

    public static Facebook toFacebook(String jsonAsString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonAsString, Facebook.class);
    }
}
