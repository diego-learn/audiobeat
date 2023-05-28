package com.br.audiobeatapi.repository;

import com.br.audiobeatapi.entity.Audio;
import org.springframework.data.repository.CrudRepository;


public interface IAudioRepository extends CrudRepository<Audio, Integer> {

}
