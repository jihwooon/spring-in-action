package com.example.atddexample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectConfig {
    @Autowired
    public ObjectMapper objectMapper;

    public String toJson(Object value) throws JsonProcessingException {
        return objectMapper.writeValueAsString(value);
    }

    public <T> T getValue(String content, Class<T> valueType) throws JsonProcessingException {
        return objectMapper.readValue(content, valueType);
    }
}
