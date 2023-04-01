package com.br.audiobeatapi.service;

import com.br.audiobeatapi.entity.RadioCampanha;
import com.br.audiobeatapi.entity.RadioCampanhaId;
import com.br.audiobeatapi.repository.ICampanhaRepository;
import com.br.audiobeatapi.repository.IRadioCampanhaRepository;
import com.br.audiobeatapi.repository.IRadioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class RadioCampanhaService implements IRadioCampanhaService {


    private final IRadioRepository radioRepository;
    private final ICampanhaRepository campanhaRepository;
    private final IRadioCampanhaRepository radioCampanhaRepository;


    @Override
    public RadioCampanha save(RadioCampanha radioCampanha) {
        return null;
    }

    @Override
    public RadioCampanha save(List<RadioCampanha> radioCampanhas) {

        radioCampanhas.forEach(rc -> {

            var radioT = radioRepository.save(rc.getRadio());
            var campanhaT = campanhaRepository.save(rc.getCampanha());

            rc.setId(RadioCampanhaId
                    .builder()
                    .campanhaId(campanhaT.getId())
                    .radioId(radioT.getId())
                    .build());
            var radioCampanha = radioCampanhaRepository.save(rc);

        });

        return radioCampanhas.get(0);
    }

    @Override
    public List<Optional<RadioCampanha>> findAll() {

        return radioCampanhaRepository.findAllByIdIsNotNull();

    }
}
