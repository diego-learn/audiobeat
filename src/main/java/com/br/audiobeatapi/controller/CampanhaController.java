package com.br.audiobeatapi.controller;

import com.br.audiobeatapi.dto.CampanhaDto;
import com.br.audiobeatapi.entity.Campanha;
import com.br.audiobeatapi.service.ICampanhaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/campanha")
public class CampanhaController {

    private final ICampanhaService campanhaService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista todas as Campanhas"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public ResponseEntity<List<Campanha>> getAll() {

        var response = campanhaService.getAll()
                .stream()
                .map(Optional::get)
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Salva uma campanha")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Campanha salvo com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping
    public ResponseEntity<CampanhaDto> save(@RequestParam String nomeCampanha) {
        return new ResponseEntity<>(campanhaService.save(CampanhaDto.builder().nome(nomeCampanha).build()), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<CampanhaDto> addRadio(@RequestParam Integer idRadio, @RequestParam Integer idCampanha) {
        var c = campanhaService.addRadio(idRadio, idCampanha);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(c);

    }
}


//    Employee updateEmployee = employeeRepository.findById(id)
//            .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
