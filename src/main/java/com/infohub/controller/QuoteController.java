package com.infohub.controller;

import com.infohub.service.QuoteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quote")
@CrossOrigin
public class QuoteController {

    private final QuoteService service;

    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @GetMapping
    public Object getQuote() {
        return service.getQuote();
    }
}
