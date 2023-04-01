package com.br.audiobeatapi.repository;

import com.br.audiobeatapi.entity.Radio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.*;
@Repository
public interface IRadioRepository extends PagingAndSortingRepository<Radio, Integer> {

    Optional<Radio> getRadioByIdSecomIs(Integer idSecom);

    @Override
    Page<Radio> findAll(Pageable pageable);


}
