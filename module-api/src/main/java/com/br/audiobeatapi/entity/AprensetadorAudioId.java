package com.br.audiobeatapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AprensetadorAudioId implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Column(name = "APRSTDR_ID")
    private Integer apresentadorId;

    @EqualsAndHashCode.Include
    @Column(name = "AUD_ID")
    private Integer audioId;
}
