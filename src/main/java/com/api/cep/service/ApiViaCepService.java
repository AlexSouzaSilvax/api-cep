package com.api.cep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.api.cep.entity.EnderecoViaCep;

import reactor.core.publisher.Mono;

@Service
public class ApiViaCepService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private static final String BASE_URL_API = System.getenv("URL_API_EXTERNO_VIA_CEP");

    public Mono<EnderecoViaCep> buscaCepApi(String cep) {
        return webClientBuilder.baseUrl(BASE_URL_API)
                .build()
                .get()
                .uri(cep)
                .retrieve()
                .bodyToMono(EnderecoViaCep.class);
    }
}