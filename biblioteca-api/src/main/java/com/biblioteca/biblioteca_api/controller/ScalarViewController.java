package com.biblioteca.biblioteca_api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScalarViewController {

    @GetMapping(value = "/docs", produces = MediaType.TEXT_HTML_VALUE)
    public String scalarDoc() {
        return """
            <!doctype html>
            <html>
              <head>
                <title>API Biblioteca - Documentação</title>
                <meta charset="utf-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1" />
              </head>
              <body>
                <script
                  id="api-reference"
                  data-url="/v3/api-docs">
                </script>
                <script src="https://cdn.jsdelivr.net/npm/@scalar/api-reference"></script>
              </body>
            </html>
            """;
    }
}