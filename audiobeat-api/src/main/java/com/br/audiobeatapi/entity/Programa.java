package com.br.audiobeatapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "PGRM")
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Programa extends Base {

    @Column(name = "PGRM_NM")
    private String nome;

    @Column(name = "PGRM_FX_HR_INIT")
    private String faixaHoraInit;

    @Column(name = "PGRM_FX_HR_FIM")
    private String faixaHoraFim;


    @JsonIgnore
    @OneToMany(mappedBy = "programa",
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private Set<Audio> audios = new HashSet<>();

    @NotNull
    @ManyToOne
    @JoinColumn(name = "RAD_ID")
    private Radio radio;

    @JsonIgnore
    @OneToMany(mappedBy = "programa",
            fetch = FetchType.LAZY)
    private Collection<ApresentadorPrograma> apresentadores = new ArrayList<>();


    public Programa() {
        //Construtor Vacio

    }


}
