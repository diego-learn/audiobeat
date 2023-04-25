package com.br.audiobeatapi.controller;

import com.br.audiobeatapi.entity.Radio;
import com.br.audiobeatapi.service.IRadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.br.audiobeatapi.util.ResponseUtil.formatResponsePagination;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(path = {"/api/v1/radios"})
public class RadioController {

    private final IRadioService radioService;

    @Autowired
    public RadioController(IRadioService radioService) {
        this.radioService = radioService;
    }

    @GetMapping(consumes = MediaType.ALL_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findAll(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "3") int size) {

        var contents = radioService.findAll(PageRequest.of(page, size));
        return new ResponseEntity<>(formatResponsePagination(contents, "radios"), HttpStatus.OK);
    }

}
