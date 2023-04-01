package com.br.audiobeatapi.repository;

import com.br.audiobeatapi.entity.RadioCampanha;
import com.br.audiobeatapi.entity.RadioCampanhaId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICampanhaRadioRepository extends CrudRepository<RadioCampanha, RadioCampanhaId> {
}
