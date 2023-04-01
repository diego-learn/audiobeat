package com.br.audiobeatapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class ApresentadorProgramaId implements Serializable {

    @EqualsAndHashCode.Include
    @Column(name = "APRSTDR_ID")
    private Integer apresentadorId;

    @EqualsAndHashCode.Include
    @Column(name = "PRGM_ID")
    private Integer programaId;


}
