package com.br.audiobeatapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "RAD")
@ToString
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Radio extends Base {

    @NotNull
    @Column(name = "RAD_ID_SECOM")
    private Integer idSecom;

    @NotNull
    @Column(name = "RAD_NM_FTS")
    private String NomeFantasia;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "radio",
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private Collection<Programa> programas = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "radio",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<RadioCampanha> radioCampanha = new HashSet<>();

    @NotNull
    @Column(name = "RAD_NM_COMP")
    private String nameCompany;

    @NotNull
    @Column(name = "RAD_CNPJ")
    private String cnpj;


    @Embedded
    private RadioCaract radioCaract;

    public Radio() {

        //Construtor Vacio
    }

}
