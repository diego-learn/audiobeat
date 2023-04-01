package com.br.audiobeatapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "APRSTDR_PROGRM")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApresentadorPrograma {


    @EmbeddedId
    private ApresentadorProgramaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("APRSTDR_ID")
    @JoinColumn(name = "APRSTDR_ID")
    private Apresentador apresentador;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("PRGM_ID")
    @JoinColumn(name = "PRGM_ID")
    private Programa programa;
}
