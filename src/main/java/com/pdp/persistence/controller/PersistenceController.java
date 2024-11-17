package com.pdp.persistence.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/persistence")
public class PersistenceController {

    @GetMapping
    public String get() {
        return "success";
    }
}
