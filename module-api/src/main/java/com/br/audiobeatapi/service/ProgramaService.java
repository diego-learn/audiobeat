package com.br.audiobeatapi.service;

import com.br.audiobeatapi.entity.Programa;
import com.br.audiobeatapi.exception.NotSuchElementException;
import com.br.audiobeatapi.repository.IProgramaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProgramaService implements IProgramaService {

    private final IProgramaRepository programaRepository;


    @Override
    public Programa save(Programa programa) {
        return programaRepository.save(programa);
    }

    @Override
    public List<Optional<Programa>> getProgramas() {
        return programaRepository.findAllByIdIsNotNull();
    }

    @Override
    public Programa getProgramaById(int id) {


        return programaRepository.findById(id)
                .stream()
                .findFirst()
                .orElseThrow(() -> new NotSuchElementException("Elemento: " + id + " não achado"));

    }

    @Override
    public Optional<Programa> getOptionalProgramaById(int id) {
        return programaRepository.findById(id);
    }
}
