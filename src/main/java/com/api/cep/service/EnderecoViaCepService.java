package com.api.cep.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.api.cep.entity.EnderecoViaCep;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;
@Service
@AllArgsConstructor
public class EnderecoViaCepService {

    private final ApiViaCepService apiViaCepService;

    public Mono<EnderecoViaCep> findByCep(String cep) {
        if(isValidCEP(cep)) {
            return apiViaCepService.buscaCepApi(cep + "/json/");
        } else {
            return Mono.error(new IllegalArgumentException("CEP inválido. Por favor, insira um CEP no formato válido."));
        }
    }

    public static boolean isValidCEP(String cep) {
        String regex = "^[0-9]{5}-?[0-9]{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(cep);
        return matcher.matches();
    }

}
