package com.br.audiobeatapi.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "APRSTDR_AUD")
@Entity
@Data
public class ApresentadorAudio implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AprensetadorAudioId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("APRSTDR_ID")
    @JoinColumn(name = "APRSTDR_ID")
    private Apresentador apresentador;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("AUD_ID")
    @JoinColumn(name = "AUD_ID")
    private Audio audio;
}
