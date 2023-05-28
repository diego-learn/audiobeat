package com.br.audiobeatapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "RAD_CAMPNH")
@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class RadioCampanha implements Serializable {

    private static final long serialVersionUID = 1L;


    @EmbeddedId
    private RadioCampanhaId id;

    @ManyToOne(fetch = FetchType.EAGER)
//    @MapsId("RAD_ID")
    @JoinColumn(name = "RAD_ID", nullable = false, insertable = false, updatable = false)
    private Radio radio;

    @ManyToOne(fetch = FetchType.EAGER)
//    @MapsId("CAMPH_ID")
    @JoinColumn(name = "CAMPH_ID", nullable = false, insertable = false, updatable = false)
    private Campanha campanha;


    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_AT")
    private Date createdAt;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_AT")
    private Date updatedAt;


    public RadioCampanha() {
        //Construtor Vacio
    }

    @PrePersist
    public void setCreationDate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void setChangeDate() {
        this.updatedAt = new Date();
    }


}
