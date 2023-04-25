package com.br.audiobeatapi.controller;

import com.br.audiobeatapi.entity.Programa;
import com.br.audiobeatapi.service.IProgramaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/programas")
public class ProgramaController {

    private final IProgramaService programaService;

    @GetMapping
    public ResponseEntity<List<Programa>> getAll() {

        var response = programaService.getProgramas()
                .stream()
                .map(Optional::get)
                .collect(Collectors.toList());


        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
