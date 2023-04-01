package com.br.audiobeatapi.service;

import com.br.audiobeatapi.entity.*;
import com.br.audiobeatapi.repository.IApresentadorProgramaRepository;
import com.br.audiobeatapi.repository.IApresentadorRepository;
import com.br.audiobeatapi.repository.IProgramaRepository;
import com.br.audiobeatapi.repository.IRadioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
public class RadioService implements IRadioService {

    private final IRadioRepository radioRepository;
    private final IProgramaRepository programaRepository;

    private final IApresentadorRepository apresentadorRepository;

    private final IApresentadorProgramaRepository apresentadorProgramaRepository;


    @Override
    @Transactional
    public Radio save(Radio radio) {
        radioRepository.getRadioByIdSecomIs(radio.getIdSecom()).ifPresentOrElse(v -> {
                    log.info(radio.getIdSecom() + " Valor Repetido!!");

                    //salva programa se não existe
                    radio.getProgramas()
                            .forEach(pr -> adicionarPrograma(pr, v));
                },
                () -> {
                    radio.getProgramas().forEach(p -> {
                        p.setRadio(radio);
                    });
                    var rd = radioRepository.save(radio);

                    rd.getProgramas().forEach(p -> {
                        saveApresentadorPrograma(p);
                    });

                });
        return radio;
    }


    @Transactional
    void adicionarPrograma(Programa programa, Radio radio) {

        programaRepository.getProgramaByNomeAndRadioId(programa.getNome(), radio.getId().intValue()).ifPresentOrElse(p -> {
                    log.info(programa.getNome() + " existe!!");
                },
                () -> {
                    programa.setRadio(radio);
                    log.info("salvando Programa");
                    var p = programaRepository.save(programa);
                    saveApresentadorPrograma(p);
                });

    }

    @Transactional
    public void saveApresentadorPrograma(Programa programa) {

        programa.getApresentadores().forEach(a -> {
            var ap = salvarApresentador(a.getApresentador());
            a.setId(new ApresentadorProgramaId(ap.getId(), programa.getId()));
            apresentadorProgramaRepository.save(a);
        });

    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Apresentador salvarApresentador(Apresentador a) {
        return apresentadorRepository.save(a);
    }


    @Override
    @Transactional
    public List<Radio> save(List<Radio> radios) {
        radios.stream().forEach(this::save);

        return radios;

    }

    @Override
    public Page<Radio> findAll(Pageable pageable) {
        return radioRepository.findAll(pageable);
    }


}
