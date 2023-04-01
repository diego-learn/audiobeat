package com.br.audiobeatapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "CAMPNH")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Campanha extends Base {

    @NotNull
    @Column(name = "CAMPNH_NM")
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "campanha",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Collection<RadioCampanha> radioCampanhas = new ArrayList<>();


    public Campanha() {

    }


    public void addRadio(Radio radio) {
        RadioCampanha rd = RadioCampanha
                .builder()
                .id(RadioCampanhaId.builder()
                        .campanhaId(this.getId())
                        .radioId(radio.getId())
                        .build())
                .build();

        radio.getRadioCampanha().add(rd);

    }


    public void removeRadio(Radio radio) {
        for (Iterator<RadioCampanha> iterator = radioCampanhas.iterator(); iterator.hasNext(); ) {
            RadioCampanha rc = iterator.next();

            if (rc.getCampanha().equals(this) && rc.getRadio().equals(radio)) {
                iterator.remove();
                rc.getCampanha().getRadioCampanhas().remove(rc);
                rc.setCampanha(null);
                rc.setRadio(null);
            }
        }
    }
}
