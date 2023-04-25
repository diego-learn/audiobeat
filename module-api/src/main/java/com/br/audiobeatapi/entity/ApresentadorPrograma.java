package com.br.audiobeatapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "APRSTDR_PROGRM")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApresentadorPrograma implements Serializable {

    private static final long serialVersionUID = 1L;


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
