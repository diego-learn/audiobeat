package com.br.audiobeatapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class RadioCampanhaId  implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name = "RAD_ID")
    private Integer radioId;

    @EqualsAndHashCode.Include
    @Column(name = "CAMPH_ID")
    private Integer campanhaId;



}
