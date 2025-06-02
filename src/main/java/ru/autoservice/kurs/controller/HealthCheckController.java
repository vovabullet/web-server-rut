package ru.autoservice.kurs.controller;

import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/health-check", produces = {MediaType.APPLICATION_JSON_VALUE})
public class HealthCheckController {

    private final HealthEndpoint healthEndpoint;

    public HealthCheckController(HealthEndpoint healthEndpoint) {
        this.healthEndpoint = healthEndpoint;
    }

    @GetMapping(value = "/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("{\"status\":\"OK\"}");
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<String> check() {
        String health = healthEndpoint.health().getStatus().getCode();
        return ResponseEntity.ok("{\"status\":\"" + health + "\"}");
    }
}