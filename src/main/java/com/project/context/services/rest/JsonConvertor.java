package com.project.context.services.rest;

import io.cucumber.messages.internal.com.fasterxml.jackson.databind.DeserializationFeature;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.node.JsonNodeFactory;

import java.io.IOException;

public class JsonConvertor {

    private static final ObjectMapper MAPPER;


    public static String prettyPrint(String content) {
        if (content == null || content.isEmpty()) {
            return content;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(toJson(content));
        } catch (IOException e) {
            return content;
        }
    }

    public static JsonNode toJson(Object obj) throws IOException {
        return obj instanceof JsonNode ? (JsonNode) obj : (obj instanceof String ? MAPPER.readTree(obj.toString()) : (JsonNode) MAPPER.convertValue(obj, JsonNode.class));
    }

    static {
        MAPPER = (new ObjectMapper()).setNodeFactory(JsonNodeFactory.withExactBigDecimals(true)).enable(DeserializationFeature.FAIL_ON_TRAILING_TOKENS);
    }

}
