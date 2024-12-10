package com.soap.xml_sb.jax_rs_arc_client.service;


import com.soap.xml_sb.jax_rs_arc_client.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

@RestController
@Service
public class ConsommeXMLReponse {
    private static final Logger logger = LoggerFactory.getLogger(ConsommeXMLReponse.class);
    private final String BASE_URL = "http://localhost:20000/person";
    private final RestTemplate restTemplate;

    @Autowired
    public ConsommeXMLReponse(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder
                .messageConverters(getMessageConverters())
                .build();
    }

    private List<HttpMessageConverter<?>> getMessageConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new Jaxb2RootElementHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter());
        return converters;
    }

    public ListPersonnes getAllPersonnes() {
        String url = BASE_URL + "/getAll";
        try {
            return restTemplate.getForObject(url, ListPersonnes.class);
        } catch (HttpClientErrorException e) {
            logger.error("Erreur lors de la récupération des personnes : {}: {}", e.getStatusCode(), e.getResponseBodyAsString());
            throw e;
        }
    }

    public Reponse ajouterPersonne(Personne p) {
        String url = BASE_URL + "/add";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        HttpEntity<Personne> request = new HttpEntity<>(p, headers);
        logger.info("Calling POST {} with payload {}", url, request);
        try {
            return restTemplate.postForObject(url, request, Reponse.class);
        } catch (HttpClientErrorException e) {
            logger.error("HTTP Error: {} - {}", e.getStatusCode(),
                    e.getResponseBodyAsString());
            throw e; // ou gérer l'erreur proprement
        }
    }
    public Reponse supprimerPersonne(int id) {
        return restTemplate.getForObject(BASE_URL + "/" + id + "/delete",
                Reponse.class);
    }

}