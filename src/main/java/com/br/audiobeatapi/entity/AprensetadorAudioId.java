package com.br.audiobeatapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AprensetadorAudioId implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name = "APRSTDR_ID")
    private Integer apresentadorId;

    @EqualsAndHashCode.Include
    @Column(name = "AUD_ID")
    private Integer audioId;
}
