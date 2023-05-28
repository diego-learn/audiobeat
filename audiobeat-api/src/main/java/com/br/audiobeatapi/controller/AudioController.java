package com.br.audiobeatapi.controller;

import com.br.audiobeatapi.entity.Audio;
import com.br.audiobeatapi.exception.NotSuchElementException;
import com.br.audiobeatapi.service.IAudioService;
import com.br.audiobeatapi.service.IProgramaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.*;


@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = {"/api/v1/audios"})
public class AudioController {


    private final IAudioService audioService;
    private final IProgramaService programaService;


    @PostMapping
    public ResponseEntity<String> upload(int programaId, @RequestPart("audio") MultipartFile audio) {

        programaService.getOptionalProgramaById(programaId).ifPresentOrElse(p -> {
                    //salvar em cloud
                    //

                    audioService.save(Audio
                            .builder()
                            .programa(p)
                            .nome(audio.getOriginalFilename())
                            .build());
                },
                () -> new NotSuchElementException("Elemento: " + programaId + " não achado")

        );

        return new ResponseEntity<>("Audio salvo com sucesso", HttpStatus.OK);
    }

//    @GetMapping(value = "/test")
//    public ResponseEntity<StreamingResponseBody> streamAudio() {
//        StreamingResponseBody responseBody = response -> {
//
//            log.info("consumindo audio");
////            final InputStream inputStream = audio.getInputStream();
//            final InputStream inputStream = new FileInputStream("src/main/resources/13ABR2020-0110pm-GOCHO.mp3");
//
//            byte[] bytes = new byte[1024];
//            int length;
//
//            while ((length = inputStream.read(bytes)) >= 0) {
//                response.write(bytes, 0, length);
//            }
//            inputStream.close();
//            response.flush();
//        };
//        return ResponseEntity.ok()
//                .contentType(MediaType.MULTIPART_FORM_DATA)
//                .body(responseBody);
//    }

    @GetMapping(value = "/teste")
    public ResponseEntity<Resource> streamAudi() throws IOException {

        final InputStream inputStream = new FileInputStream("src/main/resources/13ABR2020-0110pm-GOCHO.mp3");
        return ResponseEntity
                .ok(new ByteArrayResource(inputStream.readAllBytes()));
    }

}


