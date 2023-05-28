package com.br.audiobeatapi.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class RadioCampanhaId  implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Column(name = "RAD_ID")
    private Integer radioId;

    @EqualsAndHashCode.Include
    @Column(name = "CAMPH_ID")
    private Integer campanhaId;



}
