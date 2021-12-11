package com.example.gibberish.controller;

import com.example.gibberish.Gibberish;
import com.example.gibberish.repository.ProverbRepository;
import com.example.gibberish.soundex.Soundex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebController {

    private ProverbRepository repository;

    @Autowired
    WebController(ProverbRepository repository) {
        this.repository = repository;
    }

    // Generate gibberish from string
    @GetMapping("/gibber")
    Gibberish gibber(@RequestParam(required = false) String text) {
        if(text == null) {
            text = repository.getRandom();
        }
        return new Gibberish(text);
    }
}
