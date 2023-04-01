package com.br.audiobeatapi.entity;


import lombok.Data;

import javax.persistence.*;

@Table(name = "APRSTDR_AUD")
@Entity
@Data
public class ApresentadorAudio {

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
