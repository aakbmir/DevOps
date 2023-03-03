package com.practice.Jenkins.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AppController {

    private ResponseEntity<String> responseEntity;

    public AppController() {
    }

    @GetMapping("/books")
    public ResponseEntity<String> getAllBooks() {
        try {
            responseEntity = new ResponseEntity<>("Hello", HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/recommendedbooks")
    public ResponseEntity<String> getAllBooksFromRecommendedList() {
        try {
            responseEntity = new ResponseEntity<>("Hello recommended books", HttpStatus.OK);
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
