package com.br.audiobeatapi.service;

import com.br.audiobeatapi.entity.Radio;
import com.br.audiobeatapi.entity.RadioCampanha;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IUploadService {

    List<RadioCampanha> processFile(MultipartFile file, String nomeCampanha) throws IOException;

    List<Radio> processFile(MultipartFile file) throws IOException;
}
