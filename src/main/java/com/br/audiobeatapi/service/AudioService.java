package com.br.audiobeatapi.service;

import com.br.audiobeatapi.entity.Audio;
import com.br.audiobeatapi.exception.BadRequestException;
import com.br.audiobeatapi.exception.InvalidFileTypeException;
import com.br.audiobeatapi.repository.IAudioRepository;
import com.br.audiobeatapi.repository.IProgramaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class AudioService implements IAudioService {

    private IAudioRepository audioRepository;
    private IProgramaRepository programaRepository;


    @Override
    @Transactional
    public Audio save(Audio audio) {
        return audioRepository.save(audio);

    }
}
