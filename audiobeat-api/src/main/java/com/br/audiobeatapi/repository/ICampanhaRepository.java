package com.br.audiobeatapi.repository;

import com.br.audiobeatapi.entity.Campanha;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.*;

@Repository
public interface ICampanhaRepository extends CrudRepository<Campanha, Integer> {

    List<Optional<Campanha>> getCampanhasByIdIsNotNull();

    Optional<Campanha> getFirstByNomeEquals(String nome);
}
