package com.biblioteca.biblioteca_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RootController {

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    @GetMapping
    public Map<String, Object> index() {
        List<Map<String, String>> endpoints = handlerMapping.getHandlerMethods().entrySet().stream()
                .map(entry -> {
                    var mapping = entry.getKey();
                    var method = entry.getValue();

                    Map<String, String> details = new HashMap<>();
                    details.put("rota", mapping.getPatternValues().toString());
                    details.put("metodos", mapping.getMethodsCondition().getMethods().toString());
                    details.put("controller", method.getBeanType().getSimpleName());
                    details.put("metodoHandler", method.getMethod().getName());
                    return details;
                })
                .collect(Collectors.toList());

        Map<String, Object> response = new HashMap<>();
        response.put("aplicacao", "API Biblioteca");
        response.put("status", "UP");
        response.put("documentacaoSwagger", "/swagger-ui.html");
        response.put("totalEndpoints", endpoints.size());
        response.put("endpoints", endpoints);

        return response;
    }
}