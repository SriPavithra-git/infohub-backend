package com.infohub.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class QuoteService {

    private final List<String> quotes = List.of(
            "Push yourself, because no one else will do it for you.",
            "Every expert was once a beginner.",
            "Success is built one commit at a time.",
            "Small progress every day adds up to big results.",
            "Believe you can and you're halfway there.",
            "Do something today that your future self will thank you for."
    );

    public Map<String, String> getQuote() {
        int index = new Random().nextInt(quotes.size());
        return Map.of("quote", quotes.get(index));
    }
}
