package com.br.audiobeatapi.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

@Entity
@Table(name = "AUD")
@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Audio extends Base {

    @Column(name = "AUD")
    private UUID audioBlobId;

    @Column(name = "AUD_NM")
    private String nome;

    @OneToMany(mappedBy = "audio",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Collection<ApresentadorAudio> apresentadores = new ArrayList<>();

    @NotNull
    @ManyToOne
    @JoinColumn(name = "PRGM_ID")
    private Programa programa;

    public Audio() {

    }
}
