package com.br.audiobeatapi.service;

import com.br.audiobeatapi.component.ExcelMapper;
import com.br.audiobeatapi.entity.Radio;
import com.br.audiobeatapi.entity.RadioCampanha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UploadService implements IUploadService{

    private final ExcelMapper excelMapper;

    @Autowired
    UploadService(
            ExcelMapper excelMapper
    ) {
        this.excelMapper = excelMapper;
    }


    @Override
    public List<RadioCampanha> processFile(MultipartFile file, String nomeCampanha) throws IOException {

       return this.excelMapper.readFile(file)
               .stream().map(excelMapper::mapperRadioCampanha)
               .collect(Collectors.toList());
    }

    @Override
    public List<Radio> processFile(MultipartFile file) throws IOException {
        return this.excelMapper.readFile(file)
                .stream().map(excelMapper::mapperRadio)
                .collect(Collectors.toList());
    }

}
