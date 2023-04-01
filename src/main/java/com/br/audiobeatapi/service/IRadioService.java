package com.br.audiobeatapi.service;

import com.br.audiobeatapi.entity.Radio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface IRadioService {

    Radio save(Radio cliente);

    List<Radio> save(List<Radio> radios);

    Page<Radio> findAll(Pageable pageable);
}
