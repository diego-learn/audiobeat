package com.br.audiobeatapi.repository;

import com.br.audiobeatapi.entity.Apresentador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IApresentadorRepository extends CrudRepository<Apresentador, Integer> {

}
