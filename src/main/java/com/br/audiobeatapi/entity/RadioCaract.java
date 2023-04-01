package com.br.audiobeatapi.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;


@Embeddable
@Getter
@Setter
@Builder
@AllArgsConstructor
public class RadioCaract {

    @Column(name = "RAD_TP")
    @Enumerated(EnumType.STRING)
    private TipoRadio tipoRadio;

    @NotNull
    @Column(name = "RAD_MNP")
    private String municipioOut;

    @NotNull
    @Column(name = "RAD_TP_SRVC")
    private String tipoServico;

    @Column(name = "RAD_FX")
    private Faixa fx;

    @Column(name = "RAD_PRX")
    private Double prx;

    @Column(name = "RAD_PC")
    private String peca;

    @NotNull
    @Column(name = "RAD_GNR")
    private String generos;


    public RadioCaract() {

    }


    public enum TipoRadio {
        RADIO,
        NOT_INFORM
    }

    public enum Faixa {
        AM,
        FM;


      public static Faixa getfaixa(String fx) {
            if ("am".equals(fx)) {
                return AM;
            }
            return FM;
        }
    }


}
