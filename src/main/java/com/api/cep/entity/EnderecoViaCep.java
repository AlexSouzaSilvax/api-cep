package com.api.cep.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EnderecoViaCep {

    private String cep;

    private String logradouro;

    private String bairro;

    private String localidade;

    private String estado;

}
