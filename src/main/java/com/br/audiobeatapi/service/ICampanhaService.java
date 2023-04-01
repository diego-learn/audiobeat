package com.br.audiobeatapi.service;

import com.br.audiobeatapi.dto.CampanhaDto;
import com.br.audiobeatapi.entity.Campanha;

import java.util.*;


public interface ICampanhaService {

    Campanha save(Campanha campanha);

    CampanhaDto save(CampanhaDto campanhaDto);

    List<Optional<Campanha>> getAll();

    CampanhaDto addRadio(Integer idRadio, Integer idCampanha);
}
