package com.infohub.controller;

import com.infohub.service.ConverterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/convert")
@CrossOrigin
public class ConverterController {

    private final ConverterService service;

    public ConverterController(ConverterService service) {
        this.service = service;
    }

    @GetMapping
    public Object getRates() {
        return service.getRates();
    }
}
