package com.br.audiobeatapi.controller;

import com.br.audiobeatapi.entity.Campanha;
import com.br.audiobeatapi.entity.RadioCampanha;
import com.br.audiobeatapi.service.ICampanhaService;
import com.br.audiobeatapi.service.IProgramaService;
import com.br.audiobeatapi.service.IRadioCampanhaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(name = "Radio Campanha ", path = {"/api/v1/radiocampanha"})
public class RadioCampanhaController {


    private final IRadioCampanhaService radioCampanhaService;


    @ApiOperation(value = "lista todas as campanhas")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public ResponseEntity<List<RadioCampanha>> getAll() {

        var response = radioCampanhaService.findAll()
                .stream()
                .map(Optional::get)
                .collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
