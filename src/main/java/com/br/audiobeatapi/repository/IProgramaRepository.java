package com.br.audiobeatapi.repository;

import com.br.audiobeatapi.entity.Programa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface IProgramaRepository extends CrudRepository<Programa, Integer> {

    Optional<Programa> getProgramaByNomeAndRadioId(String nome, Integer radioId);

    List<Optional<Programa>> findAllByIdIsNotNull();

}
