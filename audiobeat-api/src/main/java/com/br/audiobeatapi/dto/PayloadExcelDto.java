package com.br.audiobeatapi.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@ToString
@Builder
public class PayloadExcelDto {

    private String nameCampanha;
    private Integer idSecom;
    private String ufOutorga;
    private String munOutorga;
    private String uf;
    private String munVeiculacao;
    private String nomeFantasia;
    private String nomeEmpresarial;
    private String tipoRadio;
    private String cnpj;
    private String tipoServico;
    private String generos;
    private String programa;
    private String apresentadores;
    private String fx;
    private Double prx;
    private String fxInicio;
    private String fxFim;
    private String peca;





}
