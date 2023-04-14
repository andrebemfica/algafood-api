package com.bemfis.algafoodapi.api.controller;

import com.bemfis.algafoodapi.domain.model.Estado;
import com.bemfis.algafoodapi.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/estados", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstadoCtrl {
    @Autowired
    private EstadoRepository estadoRepository;
    @GetMapping
    public List<Estado> listar(){
        return estadoRepository.listar();
    }
}
