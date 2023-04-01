package com.br.audiobeatapi.service;

import com.br.audiobeatapi.entity.Programa;

import java.util.*;

public interface IProgramaService {

    public Programa save(Programa programa);

    List<Optional<Programa>> getProgramas();

    Programa getProgramaById(int id);

    Optional<Programa> getOptionalProgramaById(int id);
}
