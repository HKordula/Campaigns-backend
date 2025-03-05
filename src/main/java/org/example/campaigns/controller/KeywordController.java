package org.example.campaigns.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/keywords")
public class KeywordController {

    @GetMapping
    public ResponseEntity<List<String>> getPredefinedKeywords() {
        List<String> predefinedKeywords = List.of("Electronics", "Fashion", "Health", "Sports", "Books");
        return ResponseEntity.ok(predefinedKeywords);
    }
}

