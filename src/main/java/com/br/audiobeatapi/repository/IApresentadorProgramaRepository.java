package com.br.audiobeatapi.repository;

import com.br.audiobeatapi.entity.ApresentadorPrograma;
import com.br.audiobeatapi.entity.ApresentadorProgramaId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IApresentadorProgramaRepository extends CrudRepository<ApresentadorPrograma, ApresentadorProgramaId> {
}
