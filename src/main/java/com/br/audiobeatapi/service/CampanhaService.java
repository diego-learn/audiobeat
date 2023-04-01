package com.br.audiobeatapi.service;

import com.br.audiobeatapi.dto.CampanhaDto;
import com.br.audiobeatapi.entity.Campanha;
import com.br.audiobeatapi.exception.ElementExistException;
import com.br.audiobeatapi.exception.NotSuchElementException;
import com.br.audiobeatapi.repository.ICampanhaRepository;
import com.br.audiobeatapi.repository.IRadioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class CampanhaService implements ICampanhaService {

    private final ICampanhaRepository campanhaRepository;
    private final IRadioRepository radioRepository;


    @Transactional
    @Override
    public Campanha save(Campanha campanha) {
        return campanhaRepository.save(campanha);
    }


    @Override
    @Transactional
    public CampanhaDto save(CampanhaDto campanhaDto) {
        ModelMapper mapper = new ModelMapper();
        campanhaRepository.getFirstByNomeEquals(campanhaDto.getNome())
                .ifPresent(c -> {
                    throw new ElementExistException("Existe campanha com o nome: " + campanhaDto.getNome());
                });


        var response = campanhaRepository.save(mapper.map(campanhaDto, Campanha.class));

        return mapper.map(response, CampanhaDto.class);
    }

    @Override
    public List<Optional<Campanha>> getAll() {
        return campanhaRepository.getCampanhasByIdIsNotNull();
    }

    @Override
    @Transactional
    public CampanhaDto addRadio(Integer idRadio, Integer idCampanha) {
        ModelMapper mapper = new ModelMapper();

        var campanha = campanhaRepository.findById(idCampanha).orElseThrow(() -> new NotSuchElementException("Campanha não existe"));
        var radio = radioRepository.findById(idRadio).orElseThrow(() -> new NotSuchElementException("Radio não existe"));

        campanha.addRadio(radio);

        return mapper.map(campanha, CampanhaDto.class);
    }

}
