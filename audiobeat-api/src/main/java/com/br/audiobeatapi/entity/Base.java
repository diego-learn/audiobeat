package com.br.audiobeatapi.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@ToString
@EqualsAndHashCode(of = {"id"})
public abstract class Base implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_AT")
    private Date createdAt;

    @JsonIgnore
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_AT")
    private Date updatedAt;


    @PrePersist
    public void setCreationDate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    public void setChangeDate() {
        this.updatedAt = new Date();
    }
}
