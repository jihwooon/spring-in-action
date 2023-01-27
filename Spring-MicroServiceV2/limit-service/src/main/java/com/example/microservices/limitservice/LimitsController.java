package com.example.microservices.limitservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    private final LimitsConfiguration configuration;

    public LimitsController(LimitsConfiguration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public Limits retrueveKunuts() {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
//        return new Limits(1,1000);
    }
}
