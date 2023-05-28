package com.br.audiobeatapi.repository;

import com.br.audiobeatapi.entity.RadioCampanha;
import com.br.audiobeatapi.entity.RadioCampanhaId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;
import java.util.*;

@Repository
public interface IRadioCampanhaRepository extends PagingAndSortingRepository<RadioCampanha, RadioCampanhaId> {

    List<Optional<RadioCampanha>> findAllByIdIsNotNull();
}
