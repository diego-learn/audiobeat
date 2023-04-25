package com.br.audiobeatapi.service;


import com.br.audiobeatapi.entity.RadioCampanha;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface IRadioCampanhaService {

    @Transactional
    RadioCampanha save(RadioCampanha radioCampanha);

    @Transactional
    RadioCampanha save(List<RadioCampanha> radioCampanhas);

    List<Optional<RadioCampanha>> findAll();
}
