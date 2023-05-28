package com.br.audiobeatapi.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = {"/api/v1/health"})
public class healthController {


    @GetMapping
    public ResponseEntity<String> health() throws IOException {
        return ResponseEntity
                .ok("Up!");
    }

}


