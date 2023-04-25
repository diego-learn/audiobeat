package com.br.audiobeatapi.controller;

import com.br.audiobeatapi.service.ICampanhaService;
import com.br.audiobeatapi.service.IRadioCampanhaService;
import com.br.audiobeatapi.service.IRadioService;
import com.br.audiobeatapi.service.IUploadService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = {"/api/v1/uploads"}, produces = APPLICATION_JSON_VALUE)
public class UploadExcelController {

    private final IUploadService uploadService;
    private final IRadioCampanhaService radioCampanhaService;
    private final IRadioService radioService;


    @PostMapping
    public ResponseEntity<String> Upload(@RequestPart("file") MultipartFile file) throws IOException {
        var list = this.uploadService.processFile(file);
        radioService.save(list);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
