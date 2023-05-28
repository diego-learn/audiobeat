package com.br.audiobeatapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

@Builder
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "APRSTDR")
public class Apresentador extends Base {


    @Column(name = "APRSTDR_NM")
    private String nome;


    @OneToMany(mappedBy = "apresentador")
    private Collection<ApresentadorAudio> apresentadorAudio = new ArrayList<>();


    @OneToMany(mappedBy = "apresentador")
    private Collection<ApresentadorPrograma> apresentadoresPrograma = new ArrayList<>();


    public Apresentador() {
        //Construtor Vacio

    }
}
